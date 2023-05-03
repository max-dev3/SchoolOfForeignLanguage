package com.example.course.controller.mongo.group;
/*
 * author Fushtei Maksym
 * project course
 * classname GroupUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/9/2022
 * Copyright notice
 */

import com.example.course.form.GroupForm;
import com.example.course.model.mongo.EducationStatus;
import com.example.course.model.mongo.GroupCapacity;
import com.example.course.model.mongo.Level;
import com.example.course.model.mongo.MongoGroup;
import com.example.course.service.mongo.contract.impls.ContractMongoServiceImpls;
import com.example.course.service.mongo.group.impls.GroupMongoServiceImpl;
import com.example.course.service.mongo.language.impls.LanguageMongoServiceImpls;
import com.example.course.service.mongo.teacher.impls.TeacherMongoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/mongo/groups")
public class GroupUIController {

    @Autowired
    GroupMongoServiceImpl mongoService;

    @Autowired
    TeacherMongoServiceImpl teacherMongoService;

    @Autowired
    LanguageMongoServiceImpls languageMongoService;

    @Autowired
    ContractMongoServiceImpls contractMongoService;

    @GetMapping("/")
    public String showAll(Model model){
        List<MongoGroup> list = mongoService.getAll();
        model.addAttribute("groups", list);
        model.addAttribute("dbname", "mongo");
        return "groups-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        if(mongoService.get(id).getAmountOfStudents() > 0){
            return "redirect:/ui/v1/mongo/groups/";
        }
        mongoService.delete(id);
        return "redirect:/ui/v1/mongo/groups/";
    }

//    @RequestMapping(value = "/query", method = RequestMethod.GET)
//    public String getGroupByLanguage(Model model){
//        List<MongoGroup> list = mongoService.getByLanguage("Англійська");
//        model.addAttribute("groups", list);
//        model.addAttribute("dbname", "mongo");
//        return "first-query-all";
//    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addGroup(Model model){
        GroupForm groupForm = new GroupForm();
        List<String> languages = languageMongoService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        List<Level> levels = Arrays.asList(Level.values());

        List<String> teachers = teacherMongoService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getLastName() + " " + name.getFirstName() + " " + name.getPatronymic()
               )
                .collect(Collectors.toList());

        model.addAttribute("group-form", groupForm);
        model.addAttribute("languages", languages);
        model.addAttribute("levels", levels);
        model.addAttribute("teachers", teachers);
        return "add-group";
    }

    public int calculateTotal(int startPrice, Level level, List<Level> levels){

        double total = startPrice;
        for (Level lev: levels) {
            if( lev == level){
                return (int) Math.round(total);
            }
            total *= 1.25;
        }

        return 0;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addGroup(@ModelAttribute("group-form") GroupForm groupForm){
        MongoGroup mongoGroup = new MongoGroup();
        mongoGroup.setName(groupForm.getName());
        mongoGroup.setDescription(groupForm.getDescription());
        mongoGroup.setLanguage(languageMongoService.get(groupForm.getLanguage().split(": ")[0]));
        List<Level> levels =  mongoGroup.getLanguage().getLevelList();
        int startPricePerLevel =  mongoGroup.getLanguage().getStartPricePerLevel();
        mongoGroup.setLevel(groupForm.getLevel());
        mongoGroup.setTeacher(teacherMongoService.get(groupForm.getTeacher().split(": ")[0]));
        mongoGroup.setTotalPrice(calculateTotal(startPricePerLevel, groupForm.getLevel(), levels));
        mongoGroup.setStartDate(LocalDate.parse(groupForm.getStartDate()));
        mongoGroup.setEndDate(mongoGroup.getStartDate().plusMonths(3));
        mongoGroup.setGroupCapacity(GroupCapacity.НЕЗАПОВНЕНА);
        mongoGroup.setEducationStatus(EducationStatus.ОЧІКУЄТЬСЯ);

        LocalDateTime timeNow = LocalDateTime.now();
        mongoGroup.setCreatedAt(timeNow);
        mongoGroup.setUpdatedAt(timeNow);
        mongoService.create(mongoGroup);

        return "redirect:/ui/v1/mongo/groups/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editGroup(Model model, @PathVariable("id") String id){
        MongoGroup group = mongoService.get(id);
        GroupForm groupForm = new GroupForm();
        groupForm.setId(group.getId());
        groupForm.setName(group.getName());
        groupForm.setDescription(group.getDescription());
        groupForm.setLanguage(group.getLanguage().getId() + ": " + group.getLanguage().getName());
        groupForm.setTeacher(group.getTeacher().getId() + ": " + group.getTeacher().getFullName());
        groupForm.setLevel(group.getLevel());
        List<String> languages = languageMongoService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        List<Level> levels = Arrays.asList(Level.values());

        List<String> teachers = teacherMongoService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getFullName())
                .collect(Collectors.toList());

        groupForm.setStartDate(group.getStartDate().toString());
        groupForm.setCreatedAt(group.getCreatedAt());
        model.addAttribute("group-form", groupForm);
        model.addAttribute("languages", languages);
        model.addAttribute("levels", levels);
        model.addAttribute("teachers", teachers);

        return "edit-group";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editGroup(@PathVariable("id") String id,
                              @ModelAttribute("group-form") GroupForm groupForm){
        MongoGroup group = mongoService.get(id);
        group.setName(groupForm.getName());
        group.setDescription(groupForm.getDescription());
        group.setLanguage(languageMongoService.get(groupForm.getLanguage().split(": ")[0]));
        group.setLevel(groupForm.getLevel());
        List<Level> levels =  group.getLanguage().getLevelList();
        int startPricePerLevel =  group.getLanguage().getStartPricePerLevel();
        group.setTeacher(teacherMongoService.get(groupForm.getTeacher().split(": ")[0]));
        group.setTotalPrice(calculateTotal(startPricePerLevel, groupForm.getLevel(), levels));
        group.setStartDate(LocalDate.parse(groupForm.getStartDate()));
        group.setEndDate(group.getStartDate().plusMonths(3));
        group.setEducationStatus(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0 ?  EducationStatus.ТРИВАЄ :
                group.getEndDate().compareTo(LocalDate.now()) < 0 ? EducationStatus.ЗАВЕРШЕНО : EducationStatus.ОЧІКУЄТЬСЯ);
        if(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0){
            group.setStartDate(LocalDate.now().plusDays(1));
            group.setEndDate(group.getStartDate().plusMonths(3));
        }
        mongoService.update(group);

        return "redirect:/ui/v1/mongo/groups/";
    }



}
