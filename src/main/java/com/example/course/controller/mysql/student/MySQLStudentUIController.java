package com.example.course.controller.mysql.student;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/20/2022
 * Copyright notice
 */

import com.example.course.form.StudentForm;
import com.example.course.model.mongo.MongoStudent;
import com.example.course.model.mysql.MySQLStudent;
import com.example.course.service.mysql.student.impls.StudentMySQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/mysql/students")
public class MySQLStudentUIController {

    @Autowired
    StudentMySQLServiceImpl mySQLService;


    @GetMapping("/")
    public String showAll(Model model){
        List<MySQLStudent> list = mySQLService.getAll();
        List<MySQLStudent> pageableList = mySQLService.getStudentByPageListed(5, 0);
        StudentForm studentForm = new StudentForm();
        model.addAttribute("students", pageableList);
        model.addAttribute("surname-form", studentForm);
        model.addAttribute("dbname", "mysql");
        model.addAttribute("page", 0);
        model.addAttribute("count", getCountPages(list) );
        return "students-all";
    }

    @GetMapping("/{page}")
    public String showPage(Model model, @PathVariable Integer page){
        List<MySQLStudent> list = mySQLService.getAll();
        List<MySQLStudent> pageableList = mySQLService.getStudentByPageListed(5, page);
        StudentForm studentForm = new StudentForm();
        model.addAttribute("students", pageableList);
        model.addAttribute("surname-form", studentForm);
        model.addAttribute("dbname", "mysql");
        model.addAttribute("page", page);
        model.addAttribute("count", getCountPages(list) );
        return "students-all";
    }

    public double extractDoublePart(double num){
        int n = (int)num;
        return num - n;
    }
    public int getCountPages(List<MySQLStudent> list){
        double countPage = (double) list.size() / mySQLService.getStudentByPageListed(5,0).size();
        if(extractDoublePart(countPage) != 0){
            countPage = (int)countPage + 1;
        }
        return (int)countPage;
    }

    @PostMapping("/")
    public String findBySurname(Model model, @ModelAttribute("surname-form") StudentForm studentForm ){
        List<MySQLStudent> students = mySQLService.getAllByStr(studentForm.getFirstName());
        model.addAttribute("students", students);
        model.addAttribute("dbname", "mysql");
        model.addAttribute("page", 0);
        model.addAttribute("count", getCountPages(students) );
        return "students-all";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        mySQLService.delete(id);

        return "redirect:/ui/v1/mysql/students/";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addStudent(Model model){
        StudentForm studentForm = new StudentForm();
        model.addAttribute("form", studentForm);
        return "add-student";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("form") StudentForm studentForm){
        MySQLStudent mySQLStudent = new MySQLStudent();
        mySQLStudent.setFirstName(studentForm.getFirstName());
        mySQLStudent.setLastName(studentForm.getLastName());
        mySQLStudent.setPatronymic(studentForm.getPatronymic());
        mySQLStudent.setAge(studentForm.getAge());
        mySQLStudent.setPhone(studentForm.getPhone());
        mySQLStudent.setEmail(studentForm.getEmail());
        mySQLStudent.setDescription(studentForm.getDescription());
        LocalDateTime timeNow = LocalDateTime.now();
        mySQLStudent.setCreatedAt(timeNow);
        mySQLStudent.setUpdatedAt(timeNow);
        mySQLService.create(mySQLStudent);
        return "redirect:/ui/v1/mysql/students/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editStudent(Model model, @PathVariable("id") Long id){
        MySQLStudent student = mySQLService.get(id);
        StudentForm studentForm = new StudentForm();
        studentForm.setId(student.getId().toString());
        studentForm.setFirstName(student.getFirstName());
        studentForm.setLastName(student.getLastName());
        studentForm.setPatronymic(student.getPatronymic());
        studentForm.setAge(student.getAge());
        studentForm.setPhone(student.getPhone());
        studentForm.setEmail(student.getEmail());
        studentForm.setDescription(student.getDescription());
        studentForm.setCreatedAt(student.getCreatedAt());


        model.addAttribute("form", studentForm);
        return "edit-student";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editStudent(@PathVariable("id") Long id,
                              @ModelAttribute("form") StudentForm studentForm){
        MySQLStudent student = mySQLService.get(id);
        student.setFirstName(studentForm.getFirstName());
        student.setLastName(studentForm.getLastName());
        student.setPatronymic(studentForm.getPatronymic());
        student.setAge(studentForm.getAge());
        student.setPhone(studentForm.getPhone());
        student.setEmail(studentForm.getEmail());
        student.setDescription(studentForm.getDescription());

        mySQLService.update(student);

        return "redirect:/ui/v1/mysql/students/";
    }
}
