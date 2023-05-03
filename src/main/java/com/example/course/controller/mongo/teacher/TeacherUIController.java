package com.example.course.controller.mongo.teacher;
/*
 * author Fushtei Maksym
 * project course
 * classname TeacherUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/8/2022
 * Copyright notice
 */


import com.example.course.form.StudentForm;
import com.example.course.form.TeacherForm;
import com.example.course.model.mongo.MongoStudent;
import com.example.course.model.mongo.MongoTeacher;
import com.example.course.model.mysql.MySQLStudent;
import com.example.course.model.mysql.MySQLTeacher;
import com.example.course.repository.mysql.TeacherMySQLRepository;
import com.example.course.service.mongo.teacher.impls.TeacherMongoServiceImpl;
import com.example.course.service.mysql.teacher.impls.TeacherMySQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@Controller
@RequestMapping("/ui/v1/mongo/teachers")
public class TeacherUIController {


    @Autowired
    TeacherMongoServiceImpl mongoService;


    @GetMapping("/")
    public String showAll(Model model){
        List<MongoTeacher> list = mongoService.getAll();
        model.addAttribute("teachers", list);
        model.addAttribute("dbname", "mongo");
        TeacherForm teacherForm = new TeacherForm();
        model.addAttribute("surname-form", teacherForm);
        return "teachers-all";
    }

    @PostMapping("/")
    public String findBySurname(Model model, @ModelAttribute("surname-form") TeacherForm teacherForm ){
        List<MongoTeacher> teachers = mongoService.getAllBySurname(teacherForm.getFirstName());
        model.addAttribute("teachers", teachers);
        model.addAttribute("dbname", "mongo");
        return "teachers-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        mongoService.delete(id);
        return "redirect:/ui/v1/mongo/teachers/";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addTeacher(Model model){
        TeacherForm teacherForm = new TeacherForm();
        model.addAttribute("teacher-form", teacherForm);
        return "add-teacher";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute("teacher-form") TeacherForm teacherForm){
        MongoTeacher mongoTeacher = new MongoTeacher();
        mongoTeacher.setFirstName(teacherForm.getFirstName());
        mongoTeacher.setLastName(teacherForm.getLastName());
        mongoTeacher.setPatronymic(teacherForm.getPatronymic());
        mongoTeacher.setPhone(teacherForm.getPhone());
        mongoTeacher.setEmail(teacherForm.getEmail());
        mongoTeacher.setExperience(teacherForm.getExperience());
        mongoTeacher.setDescription(teacherForm.getDescription());
        LocalDateTime timeNow = LocalDateTime.now();
        mongoTeacher.setCreatedAt(timeNow);
        mongoTeacher.setUpdatedAt(timeNow);
        mongoService.create(mongoTeacher);

        return "redirect:/ui/v1/mongo/teachers/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTeacher(Model model, @PathVariable("id") String id){
        MongoTeacher teacher = mongoService.get(id);
        TeacherForm teacherForm = new TeacherForm();
        teacherForm.setId(teacher.getId());
        teacherForm.setFirstName(teacher.getFirstName());
        teacherForm.setLastName(teacher.getLastName());
        teacherForm.setPatronymic(teacher.getPatronymic());
        teacherForm.setPhone(teacher.getPhone());
        teacherForm.setEmail(teacher.getEmail());
        teacherForm.setExperience(teacher.getExperience());
        teacherForm.setDescription(teacher.getDescription());
        teacherForm.setCreatedAt(teacher.getCreatedAt());


        model.addAttribute("teacher-form", teacherForm);
        return "edit-teacher";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editTeacher(@PathVariable("id") String id,
                              @ModelAttribute("teacher-form") TeacherForm teacherForm){
        MongoTeacher teacher = mongoService.get(id);
        teacher.setFirstName(teacherForm.getFirstName());
        teacher.setLastName(teacherForm.getLastName());
        teacher.setPatronymic(teacherForm.getPatronymic());
        teacher.setPhone(teacherForm.getPhone());
        teacher.setEmail(teacherForm.getEmail());
        teacher.setExperience(teacherForm.getExperience());
        teacher.setDescription(teacherForm.getDescription());

        mongoService.update(teacher);

        return "redirect:/ui/v1/mongo/teachers/";
    }

}
