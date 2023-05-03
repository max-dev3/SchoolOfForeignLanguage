package com.example.course.controller.mongo.studentexam;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentExamUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/27/2022
 * Copyright notice
 */

import com.example.course.form.StudentExamForm;
import com.example.course.model.mongo.MongoStudentExam;
import com.example.course.service.mongo.exam.impls.ExamMongoServiceImpl;
import com.example.course.service.mongo.student.impls.StudentMongoServiceImpl;
import com.example.course.service.mongo.studentexam.impls.StudentExamMongoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/mongo/student-exams")
public class StudentExamUIController {

    @Autowired
    StudentExamMongoServiceImpl studentExamService;

    @Autowired
    StudentMongoServiceImpl studentService;

    @Autowired
    ExamMongoServiceImpl examService;


    @GetMapping("/")
    public String showAll(Model model){
        List<MongoStudentExam> list = studentExamService.getAll();
        model.addAttribute("studentexams", list);
        model.addAttribute("dbname", "mongo");
        return "studentexams-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        studentExamService.delete(id);
        return "redirect:/ui/v1/mongo/student-exams/";
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addExam(Model model){
        StudentExamForm examForm = new StudentExamForm();

        List<String> examList = examService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());

        List<String> studentList = studentService.getAll().stream()
                .map(name -> name.getId() + ": "+ name.getFullName())
                .collect(Collectors.toList());

        model.addAttribute("exam-form", examForm);
        model.addAttribute("exams", examList);
        model.addAttribute("students", studentList);
        return "add-student-exam";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addExam(@ModelAttribute("exam-form") StudentExamForm examForm){
        MongoStudentExam exam = new MongoStudentExam();
        exam.setName(examForm.getName());
        exam.setDescription(examForm.getDescription());
        exam.setExam(examService.get(examForm.getExam().split(": ")[0]));
        exam.setStudent(studentService.get(examForm.getStudent().split(": ")[0]));
        exam.setMark(examForm.getMark());
        exam.setCertificate(exam.getMark() > 50);
        LocalDateTime timeNow = LocalDateTime.now();
        exam.setUpdatedAt(timeNow);
        exam.setCreatedAt(timeNow);
        studentExamService.create(exam);
        return "redirect:/ui/v1/mongo/student-exams/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editExam(Model model, @PathVariable("id") String id){
        MongoStudentExam exam = studentExamService.get(id);
        StudentExamForm examForm = new StudentExamForm();
        examForm.setId(examForm.getId());
        examForm.setName(exam.getName());
        examForm.setDescription(exam.getDescription());
        examForm.setExam(exam.getExam().getId() + ": " + exam.getExam().getName());
        examForm.setStudent(exam.getStudent().getId() + ": " + exam.getStudent().getFullName());
        List<String> examList = examService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        examForm.setMark(exam.getMark());

        List<String> studentList = studentService.getAll().stream()
                .map(name -> name.getId() + ": "+ name.getFullName())
                .collect(Collectors.toList());

        model.addAttribute("exam-form", examForm);
        model.addAttribute("exams", examList);
        model.addAttribute("students", studentList);
        return "edit-student-exam";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editExam(@PathVariable("id") String id,
                              @ModelAttribute("exam-form") StudentExamForm examForm){
        MongoStudentExam exam = studentExamService.get(id);
        exam.setName(examForm.getName());
        exam.setDescription(examForm.getDescription());
        exam.setExam(examService.get(examForm.getExam().split(": ")[0]));
        exam.setStudent(studentService.get(examForm.getStudent().split(": ")[0]));
        exam.setMark(examForm.getMark());
        exam.setCertificate(exam.getMark() > 50);
        studentExamService.update(exam);
        return "redirect:/ui/v1/mongo/student-exams/";
    }


}
