package com.example.course.controller.mongo.subject;
/*
 * author Fushtei Maksym
 * project course
 * classname SubjectUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/17/2022
 * Copyright notice
 */


import com.example.course.form.LanguageForm;
import com.example.course.form.SubjectForm;
import com.example.course.model.mongo.Level;
import com.example.course.model.mongo.MongoLanguage;
import com.example.course.model.mongo.MongoSubject;
import com.example.course.service.mongo.subject.impls.SubjectMongoServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/mongo/subjects")
public class SubjectUIController {

    @Autowired
    SubjectMongoServiceImpls service;


    @GetMapping("/")
    public String showAll(Model model){
        List<MongoSubject> list = service.getAll();

        model.addAttribute("subjects", list);
        model.addAttribute("dbname", "mongo");
        return "subjects-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongo/subjects/";
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addSubject(Model model){
        SubjectForm subjectForm = new SubjectForm();
        model.addAttribute("subject-form", subjectForm);
        return "add-subject";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addSubject(@ModelAttribute("subject-form") SubjectForm subjectForm){
        MongoSubject subject = new MongoSubject();
        subject.setName(subjectForm.getName());
        subject.setDescription(subjectForm.getDescription());
        LocalDateTime timeNow = LocalDateTime.now();
        subject.setUpdatedAt(timeNow);
        subject.setCreatedAt(timeNow);
        service.create(subject);

        return "redirect:/ui/v1/mongo/subjects/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editSubject(Model model, @PathVariable("id") String id){
        MongoSubject subject = service.get(id);
        SubjectForm subjectForm = new SubjectForm();
        subjectForm.setId(subjectForm.getId());
        subjectForm.setName(subject.getName());
        subjectForm.setDescription(subject.getDescription());
        subjectForm.setCreatedAt(subject.getCreatedAt());

        model.addAttribute("subject-form", subjectForm);

        return "edit-subject";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editSubject(@PathVariable("id") String id,
                              @ModelAttribute("language-form") SubjectForm subjectForm){
        MongoSubject subject = service.get(id);
        subject.setName(subjectForm.getName());
        subject.setDescription(subjectForm.getDescription());
        service.update(subject);
        return "redirect:/ui/v1/mongo/subjects/";
    }


}
