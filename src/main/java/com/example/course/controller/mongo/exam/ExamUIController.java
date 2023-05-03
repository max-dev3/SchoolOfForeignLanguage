package com.example.course.controller.mongo.exam;
/*
 * author Fushtei Maksym
 * project course
 * classname ExamUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */

import com.example.course.form.ExamForm;
import com.example.course.model.mongo.MongoExam;
import com.example.course.service.mongo.exam.impls.ExamMongoServiceImpl;
import com.example.course.service.mongo.group.impls.GroupMongoServiceImpl;
import com.example.course.service.mongo.student.impls.StudentMongoServiceImpl;
import com.example.course.service.mongo.subject.impls.SubjectMongoServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/mongo/exams")
public class ExamUIController {

    @Autowired
    ExamMongoServiceImpl service;

    @Autowired
    StudentMongoServiceImpl studentService;

    @Autowired
    GroupMongoServiceImpl groupService;

    @Autowired
    SubjectMongoServiceImpls subjectService;


    @GetMapping("/")
    public String showAll(Model model){
        List<MongoExam> list = service.getAll();
        model.addAttribute("exams", list);
        model.addAttribute("dbname", "mongo");
        return "exams-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongo/exams/";
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addExam(Model model){
        ExamForm examForm = new ExamForm();


        List<String> groupList = groupService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        List<String> subjectList = subjectService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());


        model.addAttribute("exam-form", examForm);
        model.addAttribute("groups", groupList);
        model.addAttribute("subjects", subjectList);
        return "add-exam";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addExam(@ModelAttribute("exam-form") ExamForm examForm){
        MongoExam exam = new MongoExam();
        exam.setName(examForm.getName());
        exam.setDescription(examForm.getDescription());
        exam.setGroup(groupService.get(examForm.getGroup().split(": ")[0]));
        exam.setSubject(subjectService.get(examForm.getSubject().split(": ")[0]));
        exam.setDateOfExam(groupService.get(examForm.getGroup().split(": ")[0]).getEndDate());
        LocalDateTime timeNow = LocalDateTime.now();
        exam.setUpdatedAt(timeNow);
        exam.setCreatedAt(timeNow);
        service.create(exam);
        return "redirect:/ui/v1/mongo/exams/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editExam(Model model, @PathVariable("id") String id){
        MongoExam exam = service.get(id);
        ExamForm examForm = new ExamForm();
        examForm.setId(examForm.getId());
        examForm.setName(exam.getName());
        examForm.setDescription(exam.getDescription());
        examForm.setGroup(exam.getGroup().getId() + ": " + exam.getGroup().getName());
        examForm.setSubject(exam.getSubject().getId() + ": " + exam.getSubject().getName());
        List<String> groupList = groupService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        List<String> subjectList = subjectService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        examForm.setCreatedAt(exam.getCreatedAt());

        model.addAttribute("exam-form", examForm);
        model.addAttribute("groups", groupList);
        model.addAttribute("subjects", subjectList);
        return "edit-exam";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editSubject(@PathVariable("id") String id,
                              @ModelAttribute("exam-form") ExamForm examForm){
        MongoExam exam = service.get(id);
        exam.setName(examForm.getName());
        exam.setDescription(examForm.getDescription());
        exam.setGroup(groupService.get(examForm.getGroup().split(": ")[0]));
        exam.setSubject(subjectService.get(examForm.getSubject().split(": ")[0]));
        exam.setDateOfExam(groupService.get(examForm.getGroup().split(": ")[0]).getEndDate());
        service.update(exam);
        return "redirect:/ui/v1/mongo/exams/";
    }



}
