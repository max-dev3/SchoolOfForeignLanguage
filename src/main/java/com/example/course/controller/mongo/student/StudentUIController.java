package com.example.course.controller.mongo.student;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/5/2022
 * Copyright notice
 */

import com.example.course.form.StudentForm;
import com.example.course.model.mongo.MongoStudent;
import com.example.course.model.mysql.MySQLStudent;
import com.example.course.service.mongo.student.impls.StudentMongoServiceImpl;
import com.example.course.service.mysql.student.impls.StudentMySQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/mongo/students")
public class StudentUIController {

     @Autowired
     StudentMongoServiceImpl mongoService;


     @GetMapping("/")
     public String showAll(Model model){
          List<MongoStudent> list = mongoService.getAll();
          List<MongoStudent> pageableList = mongoService.getStudentByPageListed(5, 0);
          StudentForm studentForm = new StudentForm();
          model.addAttribute("students", pageableList);
          model.addAttribute("surname-form", studentForm);
          model.addAttribute("dbname", "mongo");
          model.addAttribute("page", 0);
          model.addAttribute("count",getCountPages(list) );

          return "students-all";
     }

     public double extractDoublePart(double num){
          int n = (int)num;
          return num - n;
     }

     public int getCountPages(List<MongoStudent> list){
          double countPage = (double) list.size() / mongoService.getStudentByPageListed(5,0).size();
          if(extractDoublePart(countPage) != 0){
               countPage = (int)countPage + 1;
          }
          return (int)countPage;
     }
     @GetMapping("/{page}")
     public String showPage(Model model, @PathVariable Integer page){
          List<MongoStudent> list = mongoService.getAll();
          List<MongoStudent> pageableList = mongoService.getStudentByPageListed(5, page);
          StudentForm studentForm = new StudentForm();
          model.addAttribute("students", pageableList);
          model.addAttribute("surname-form", studentForm);
          model.addAttribute("dbname", "mongo");
          model.addAttribute("page", page);
          model.addAttribute("count", getCountPages(list) );
          return "students-all";
     }


     @PostMapping("/")
     public String findBySurname(Model model, @ModelAttribute("surname-form") StudentForm studentForm ){
          if(!studentForm.getFirstName().equals("")){
               List<MongoStudent> students = mongoService.getAllByStr(studentForm.getFirstName());
               model.addAttribute("students", students);
               model.addAttribute("count", getCountPages(students) );
          }
          else {
               List<MongoStudent> list = mongoService.getAll();
               List<MongoStudent> studentList = mongoService.getStudentByPageListed(5, 0);
               model.addAttribute("students", studentList);
               model.addAttribute("count", getCountPages(list) );

          }

          model.addAttribute("dbname", "mongo");
          model.addAttribute("page", 0);
          return "students-all";
     }


     @GetMapping("/delete/{id}")
     public String delete(@PathVariable String id){
          mongoService.delete(id);

          return "redirect:/ui/v1/mongo/students/";
     }

     @RequestMapping(value = "", method = RequestMethod.GET)
     public String addStudent(Model model){
          StudentForm studentForm = new StudentForm();
          model.addAttribute("form", studentForm);
          return "add-student";
     }

     @RequestMapping(value = "", method = RequestMethod.POST)
     public String addStudent(@ModelAttribute("form") StudentForm studentForm){
          MongoStudent mongoStudent = new MongoStudent();
          mongoStudent.setFirstName(studentForm.getFirstName());
          mongoStudent.setLastName(studentForm.getLastName());
          mongoStudent.setPatronymic(studentForm.getPatronymic());
          mongoStudent.setAge(studentForm.getAge());
          mongoStudent.setPhone(studentForm.getPhone());
          mongoStudent.setEmail(studentForm.getEmail());
          mongoStudent.setDescription(studentForm.getDescription());
          LocalDateTime timeNow = LocalDateTime.now();
          mongoStudent.setCreatedAt(timeNow);
          mongoStudent.setUpdatedAt(timeNow);
          mongoService.create(mongoStudent);
          return "redirect:/ui/v1/mongo/students/";
     }

     @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
     public String editStudent(Model model, @PathVariable("id") String id){
          MongoStudent student = mongoService.get(id);
          StudentForm studentForm = new StudentForm();
          studentForm.setId(student.getId());
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
     public String editStudent(@PathVariable("id") String id,
             @ModelAttribute("form") StudentForm studentForm){
          MongoStudent student = mongoService.get(id);
          student.setFirstName(studentForm.getFirstName());
          student.setLastName(studentForm.getLastName());
          student.setPatronymic(studentForm.getPatronymic());
          student.setAge(studentForm.getAge());
          student.setPhone(studentForm.getPhone());
          student.setEmail(studentForm.getEmail());
          student.setDescription(studentForm.getDescription());

          mongoService.update(student);

          return "redirect:/ui/v1/mongo/students/";
     }





}
