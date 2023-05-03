package com.example.course.controller.mongo.schedule;
/*
 * author Fushtei Maksym
 * project course
 * classname ScheduleUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */

import com.example.course.form.ExamForm;
import com.example.course.form.ScheduleForm;
import com.example.course.form.StudentForm;
import com.example.course.model.mongo.Day;
import com.example.course.model.mongo.MongoExam;
import com.example.course.model.mongo.MongoSchedule;
import com.example.course.model.mongo.MongoStudent;
import com.example.course.service.mongo.group.impls.GroupMongoServiceImpl;
import com.example.course.service.mongo.schedule.impls.ScheduleMongoServiceImpls;
import com.example.course.service.mongo.subject.impls.SubjectMongoServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/mongo/schedules")
public class ScheduleUIController {

    @Autowired
    ScheduleMongoServiceImpls scheduleService;

    @Autowired
    GroupMongoServiceImpl groupService;

    @Autowired
    SubjectMongoServiceImpls subjectService;

    @GetMapping("/")
    public String showAll(Model model){
        List<MongoSchedule> list = scheduleService.getAll();
        model.addAttribute("schedules", list);
        model.addAttribute("dbname", "mongo");
        ScheduleForm scheduleForm = new ScheduleForm();
        model.addAttribute("surname-form", scheduleForm);
        return "schedules-all";
    }
    @PostMapping("/")
    public String findBySurname(Model model, @ModelAttribute("surname-form") ScheduleForm scheduleForm ){
        List<MongoSchedule> schedules = scheduleService.getAllByDay(scheduleForm.getGroup());
        model.addAttribute("schedules", schedules);
        model.addAttribute("dbname", "mongo");
        return "schedules-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        scheduleService.delete(id);
        return "redirect:/ui/v1/mongo/schedules/";
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addSchedule(Model model){
        ScheduleForm scheduleForm = new ScheduleForm();

        List<Day> days = Arrays.asList(Day.values());

        List<String> groupList = groupService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        List<String> subjectList = subjectService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());


        model.addAttribute("schedule-form", scheduleForm);
        model.addAttribute("groups", groupList);
        model.addAttribute("days", days);
        model.addAttribute("subjects", subjectList);
        return "add-schedule";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addSchedule(@ModelAttribute("schedule-form") ScheduleForm scheduleForm){
        MongoSchedule mongoSchedule = new MongoSchedule();
        mongoSchedule.setDay(scheduleForm.getDay());
        mongoSchedule.setClassroom(scheduleForm.getClassroom());
        mongoSchedule.setGroup(groupService.get(scheduleForm.getGroup().split(": ")[0]));
        mongoSchedule.setStartLesson(LocalTime.parse(scheduleForm.getStartLesson()));
        mongoSchedule.setEndLesson(mongoSchedule.getStartLesson().plusHours(1));
        mongoSchedule.setSubject(subjectService.get(scheduleForm.getSubject().split(": ")[0]));
        mongoSchedule.setTeacher(mongoSchedule.getGroup().getTeacher());
        LocalDateTime timeNow = LocalDateTime.now();
        mongoSchedule.setUpdatedAt(timeNow);
        mongoSchedule.setCreatedAt(timeNow);
        scheduleService.create(mongoSchedule);
        return "redirect:/ui/v1/mongo/schedules/";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editSchedule(Model model, @PathVariable("id") String id){
        MongoSchedule mongoSchedule = scheduleService.get(id);
        ScheduleForm scheduleForm = new ScheduleForm();
        scheduleForm.setId(scheduleForm.getId());
        scheduleForm.setDay(mongoSchedule.getDay());
        scheduleForm.setGroup(mongoSchedule.getGroup().getId() + ": "+ mongoSchedule.getGroup().getName());
        scheduleForm.setSubject(mongoSchedule.getSubject().getId() + ": " + mongoSchedule.getSubject().getName());
        scheduleForm.setClassroom(mongoSchedule.getClassroom());
        scheduleForm.setStartLesson(mongoSchedule.getStartLesson().toString());
        List<Day> days = Arrays.asList(Day.values());
        List<String> groupList = groupService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        List<String> subjectList = subjectService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());

        model.addAttribute("schedule-form", scheduleForm);
        model.addAttribute("groups", groupList);
        model.addAttribute("subjects", subjectList);
        model.addAttribute("days", days);
        return "edit-schedule";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editSubject(@PathVariable("id") String id,
                              @ModelAttribute("exam-form") ScheduleForm scheduleForm){
        MongoSchedule mongoSchedule = scheduleService.get(id);
        mongoSchedule.setDay(scheduleForm.getDay());
        mongoSchedule.setClassroom(scheduleForm.getClassroom());
        mongoSchedule.setGroup(groupService.get(scheduleForm.getGroup().split(": ")[0]));
        mongoSchedule.setStartLesson(LocalTime.parse(scheduleForm.getStartLesson()));
        mongoSchedule.setEndLesson(mongoSchedule.getStartLesson().plusHours(1));
        mongoSchedule.setSubject(subjectService.get(scheduleForm.getSubject().split(": ")[0]));
        mongoSchedule.setTeacher(mongoSchedule.getGroup().getTeacher());
        LocalDateTime timeNow = LocalDateTime.now();
        mongoSchedule.setUpdatedAt(timeNow);
        scheduleService.update(mongoSchedule);
        return "redirect:/ui/v1/mongo/schedules/";
    }




}
