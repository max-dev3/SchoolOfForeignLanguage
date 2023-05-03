package com.example.course.controller.mysql.teacher;
/*
 * author Fushtei Maksym
 * project course
 * classname MySQLTeacherUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/20/2022
 * Copyright notice
 */

import com.example.course.form.TeacherForm;
import com.example.course.model.mongo.MongoTeacher;
import com.example.course.model.mysql.MySQLStudent;
import com.example.course.model.mysql.MySQLTeacher;
import com.example.course.service.mysql.teacher.impls.TeacherMySQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/mysql/teachers")
public class MySQLTeacherUIController {

    @Autowired
    TeacherMySQLServiceImpl mySQLService;


    @GetMapping("/")
    public String showAll(Model model){
        List<MySQLTeacher> list = mySQLService.getAll();
        model.addAttribute("teachers", list);
        model.addAttribute("dbname", "mysql");
        TeacherForm teacherForm = new TeacherForm();
        model.addAttribute("surname-form", teacherForm);
        return "teachers-all";
    }
    @PostMapping("/")
    public String findBySurname(Model model, @ModelAttribute("surname-form") TeacherForm teacherForm ){
        List<MySQLTeacher> teachers = mySQLService.getAllBySurname(teacherForm.getFirstName());
        model.addAttribute("teachers", teachers);
        model.addAttribute("dbname", "mysql");
        return "teachers-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        mySQLService.delete(id);
        return "redirect:/ui/v1/mysql/teachers/";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addTeacher(Model model){
        TeacherForm teacherForm = new TeacherForm();
        model.addAttribute("teacher-form", teacherForm);
        return "add-teacher";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute("teacher-form") TeacherForm teacherForm){
        MySQLTeacher mySQLTeacher = new MySQLTeacher();
        mySQLTeacher.setFirstName(teacherForm.getFirstName());
        mySQLTeacher.setLastName(teacherForm.getLastName());
        mySQLTeacher.setPatronymic(teacherForm.getPatronymic());
        mySQLTeacher.setPhone(teacherForm.getPhone());
        mySQLTeacher.setEmail(teacherForm.getEmail());
        mySQLTeacher.setExperience(teacherForm.getExperience());
        mySQLTeacher.setDescription(teacherForm.getDescription());
        LocalDateTime timeNow = LocalDateTime.now();
        mySQLTeacher.setCreatedAt(timeNow);
        mySQLTeacher.setUpdatedAt(timeNow);
        mySQLService.create(mySQLTeacher);

        return "redirect:/ui/v1/mysql/teachers/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTeacher(Model model, @PathVariable("id") Long id){
        MySQLTeacher teacher = mySQLService.get(id);
        TeacherForm teacherForm = new TeacherForm();
        teacherForm.setId(teacher.getId().toString());
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
    public String editTeacher(@PathVariable("id") Long id,
                              @ModelAttribute("teacher-form") TeacherForm teacherForm){
        MySQLTeacher teacher = mySQLService.get(id);
        teacher.setFirstName(teacherForm.getFirstName());
        teacher.setLastName(teacherForm.getLastName());
        teacher.setPatronymic(teacherForm.getPatronymic());
        teacher.setPhone(teacherForm.getPhone());
        teacher.setEmail(teacherForm.getEmail());
        teacher.setExperience(teacherForm.getExperience());
        teacher.setDescription(teacherForm.getDescription());

        mySQLService.update(teacher);

        return "redirect:/ui/v1/teachers/";
    }

}
