package com.example.course.controller.mysql.exam;
/*
 * author Fushtei Maksym
 * project course
 * classname MySQLExamController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/22/2022
 * Copyright notice
 */

import com.example.course.form.ExamForm;
import com.example.course.model.mysql.MySQLExam;
import com.example.course.service.mysql.exam.impls.ExamMySQLServiceImpl;
import com.example.course.service.mysql.group.impls.GroupMySQLServiceImpl;
import com.example.course.service.mysql.student.impls.StudentMySQLServiceImpl;
import com.example.course.service.mysql.subject.impls.SubjectMySQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/mysql/exams")
public class MySQLExamUIController {

    @Autowired
    ExamMySQLServiceImpl examService;

    @Autowired
    StudentMySQLServiceImpl studentService;

    @Autowired
    GroupMySQLServiceImpl groupService;

    @Autowired
    SubjectMySQLServiceImpl subjectService;


    @GetMapping("/")
    public String showAll(Model model){
        List<MySQLExam> list = examService.getAll();
        model.addAttribute("exams", list);
        model.addAttribute("dbname", "mysql");
        return "exams-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        examService.delete(id);
        return "redirect:/ui/v1/mysql/exams/";
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
        MySQLExam exam = new MySQLExam();
        exam.setName(examForm.getName());
        exam.setDescription(examForm.getDescription());
        exam.setGroup(groupService.get(Long.valueOf(examForm.getGroup().split(": ")[0])));
        exam.setSubject(subjectService.get(Long.valueOf(examForm.getSubject().split(": ")[0])));
        exam.setDateOfExam(exam.getGroup().getEndDate());
        LocalDateTime timeNow = LocalDateTime.now();
        exam.setUpdatedAt(timeNow);
        exam.setCreatedAt(timeNow);
        examService.create(exam);
        return "redirect:/ui/v1/mysql/exams/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editExam(Model model, @PathVariable("id") Long id){
        MySQLExam exam = examService.get(id);
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

        model.addAttribute("exam-form", examForm);
        model.addAttribute("groups", groupList);
        model.addAttribute("subjects", subjectList);
        return "edit-exam";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editSubject(@PathVariable("id") Long id,
                              @ModelAttribute("exam-form") ExamForm examForm){
        MySQLExam exam = examService.get(id);
        exam.setName(examForm.getName());
        exam.setDescription(examForm.getDescription());
        exam.setGroup(groupService.get(Long.valueOf(examForm.getGroup().split(": ")[0])));
        exam.setSubject(subjectService.get(Long.valueOf(examForm.getSubject().split(": ")[0])));
        exam.setDateOfExam(exam.getGroup().getEndDate());
        examService.update(exam);
        return "redirect:/ui/v1/mysql/exams/";
    }


}
