package com.example.course.controller.mysql.subject;
/*
 * author Fushtei Maksym
 * project course
 * classname SubjectUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/17/2022
 * Copyright notice
 */


import com.example.course.form.SubjectForm;
import com.example.course.model.mysql.MySQLSubject;
import com.example.course.service.mysql.subject.impls.SubjectMySQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/mysql/subjects")
public class MySQLSubjectUIController {

    @Autowired
    SubjectMySQLServiceImpl service;


    @GetMapping("/")
    public String showAll(Model model){
        List<MySQLSubject> list = service.getAll();

        model.addAttribute("subjects", list);
        model.addAttribute("dbname", "mysql");
        return "subjects-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/ui/v1/mysql/subjects/";
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addSubject(Model model){
        SubjectForm subjectForm = new SubjectForm();
        model.addAttribute("subject-form", subjectForm);
        return "add-subject";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addSubject(@ModelAttribute("subject-form") SubjectForm subjectForm){
        MySQLSubject subject = new MySQLSubject();
        subject.setName(subjectForm.getName());
        subject.setDescription(subjectForm.getDescription());
        LocalDateTime timeNow = LocalDateTime.now();
        subject.setUpdatedAt(timeNow);
        subject.setCreatedAt(timeNow);
        service.create(subject);

        return "redirect:/ui/v1/mysql/subjects/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editSubject(Model model, @PathVariable("id") Long id){
        MySQLSubject subject = service.get(id);
        SubjectForm subjectForm = new SubjectForm();
        subjectForm.setId(subjectForm.getId());
        subjectForm.setName(subject.getName());
        subjectForm.setDescription(subject.getDescription());
        subjectForm.setCreatedAt(subject.getCreatedAt());

        model.addAttribute("subject-form", subjectForm);

        return "edit-subject";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editSubject(@PathVariable("id") Long id,
                              @ModelAttribute("language-form") SubjectForm subjectForm){
        MySQLSubject subject = service.get(id);
        subject.setName(subjectForm.getName());
        subject.setDescription(subjectForm.getDescription());
        service.update(subject);
        return "redirect:/ui/v1/mysql/subjects/";
    }


}
