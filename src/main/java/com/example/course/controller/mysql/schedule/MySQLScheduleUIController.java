package com.example.course.controller.mysql.schedule;
/*
 * author Fushtei Maksym
 * project course
 * classname ScheduleUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */

import com.example.course.form.ScheduleForm;
import com.example.course.model.mongo.Day;
import com.example.course.model.mongo.MongoSchedule;
import com.example.course.model.mysql.MySQLSchedule;
import com.example.course.service.mysql.group.impls.GroupMySQLServiceImpl;
import com.example.course.service.mysql.schedule.impls.ScheduleMySQLServiceImpl;
import com.example.course.service.mysql.subject.impls.SubjectMySQLServiceImpl;
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
@RequestMapping("/ui/v1/mysql/schedules")
public class MySQLScheduleUIController {

    @Autowired
    ScheduleMySQLServiceImpl scheduleService;

    @Autowired
    GroupMySQLServiceImpl groupService;

    @Autowired
    SubjectMySQLServiceImpl subjectService;

    @GetMapping("/")
    public String showAll(Model model){
        List<MySQLSchedule> list = scheduleService.getAll();
        model.addAttribute("schedules", list);
        model.addAttribute("dbname", "mysql");
        ScheduleForm scheduleForm = new ScheduleForm();
        model.addAttribute("surname-form", scheduleForm);
        return "schedules-all";
    }
    @PostMapping("/")
    public String findBySurname(Model model, @ModelAttribute("surname-form") ScheduleForm scheduleForm ){
        List<MySQLSchedule> schedules = scheduleService.getAllByDay(scheduleForm.getGroup());
        model.addAttribute("schedules", schedules);
        model.addAttribute("dbname", "mysql");
        return "schedules-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        scheduleService.delete(id);
        return "redirect:/ui/v1/mysql/schedules/";
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
        MySQLSchedule mySQLSchedule = new MySQLSchedule();
        mySQLSchedule.setDay(scheduleForm.getDay());
        mySQLSchedule.setClassroom(scheduleForm.getClassroom());
        mySQLSchedule.setGroup(groupService.get(Long.valueOf(scheduleForm.getGroup().split(": ")[0])));
        mySQLSchedule.setStartLesson(LocalTime.parse(scheduleForm.getStartLesson()));
        mySQLSchedule.setEndLesson(mySQLSchedule.getStartLesson().plusHours(1));
        mySQLSchedule.setSubject(subjectService.get(Long.valueOf(scheduleForm.getSubject().split(": ")[0])));
        mySQLSchedule.setTeacher(mySQLSchedule.getGroup().getTeacher());
        LocalDateTime timeNow = LocalDateTime.now();
        mySQLSchedule.setUpdatedAt(timeNow);
        mySQLSchedule.setCreatedAt(timeNow);
        scheduleService.create(mySQLSchedule);
        return "redirect:/ui/v1/mysql/schedules/";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editSchedule(Model model, @PathVariable("id") Long id){
        MySQLSchedule mySQLSchedule = scheduleService.get(id);
        ScheduleForm scheduleForm = new ScheduleForm();
        scheduleForm.setId(scheduleForm.getId());
        scheduleForm.setDay(mySQLSchedule.getDay());
        scheduleForm.setGroup(mySQLSchedule.getGroup().getId() + ": "+ mySQLSchedule.getGroup().getName());
        scheduleForm.setSubject(mySQLSchedule.getSubject().getId() + ": " + mySQLSchedule.getSubject().getName());
        scheduleForm.setClassroom(mySQLSchedule.getClassroom());
        scheduleForm.setStartLesson(mySQLSchedule.getStartLesson().toString());
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
    public String editSchedule(@PathVariable("id") Long id,
                              @ModelAttribute("exam-form") ScheduleForm scheduleForm){
        MySQLSchedule mySQLSchedule = scheduleService.get(id);
        mySQLSchedule.setDay(scheduleForm.getDay());
        mySQLSchedule.setClassroom(scheduleForm.getClassroom());
        mySQLSchedule.setGroup(groupService.get(Long.valueOf(scheduleForm.getGroup().split(": ")[0])));
        mySQLSchedule.setStartLesson(LocalTime.parse(scheduleForm.getStartLesson()));
        mySQLSchedule.setEndLesson(mySQLSchedule.getStartLesson().plusHours(1));
        mySQLSchedule.setSubject(subjectService.get(Long.valueOf(scheduleForm.getSubject().split(": ")[0])));
        mySQLSchedule.setTeacher(mySQLSchedule.getGroup().getTeacher());
        LocalDateTime timeNow = LocalDateTime.now();
        mySQLSchedule.setUpdatedAt(timeNow);
        scheduleService.update(mySQLSchedule);
        return "redirect:/ui/v1/mysql/schedules/";
    }




}
