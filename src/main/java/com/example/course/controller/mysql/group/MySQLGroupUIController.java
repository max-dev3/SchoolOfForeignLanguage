package com.example.course.controller.mysql.group;
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
import com.example.course.model.mysql.MySQLGroup;
import com.example.course.service.mysql.group.impls.GroupMySQLServiceImpl;
import com.example.course.service.mysql.language.impls.LanguageMySQLServiceImpl;
import com.example.course.service.mysql.teacher.impls.TeacherMySQLServiceImpl;
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
@RequestMapping("/ui/v1/mysql/groups")
public class MySQLGroupUIController {

    @Autowired
    GroupMySQLServiceImpl mySQLService;

    @Autowired
    TeacherMySQLServiceImpl teacherMySQLService;

    @Autowired
    LanguageMySQLServiceImpl languageMySQLService;

//    @Autowired
//    ContractMongoServiceImpls contractMongoService;

    @GetMapping("/")
    public String showAll(Model model){
        List<MySQLGroup> list = mySQLService.getAll();
        model.addAttribute("groups", list);
        model.addAttribute("dbname", "mysql");
        return "groups-all";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        if(mySQLService.get(id).getAmountOfStudents() > 0){
            return "redirect:/ui/v1/mysql/groups/";
        }
        mySQLService.delete(id);
        return "redirect:/ui/v1/mysql/groups/";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addGroup(Model model){
        GroupForm groupForm = new GroupForm();
        List<String> languages = languageMySQLService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        List<Level> levels = Arrays.asList(Level.values());

        List<String> teachers = teacherMySQLService.getAll().stream()
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
        MySQLGroup mySQLGroup = new MySQLGroup();
        mySQLGroup.setName(groupForm.getName());
        mySQLGroup.setDescription(groupForm.getDescription());
        mySQLGroup.setLanguage(languageMySQLService.get(Long.valueOf(groupForm.getLanguage().split(": ")[0])));
        List<Level> levels =  mySQLGroup.getLanguage().getLevelList();
        int startPricePerLevel =  mySQLGroup.getLanguage().getStartPricePerLevel();
        mySQLGroup.setLevel(groupForm.getLevel());
        mySQLGroup.setTeacher(teacherMySQLService.get(Long.valueOf(groupForm.getTeacher().split(": ")[0])));
        mySQLGroup.setTotalPrice(calculateTotal(startPricePerLevel, groupForm.getLevel(), levels));
        mySQLGroup.setStartDate(LocalDate.parse(groupForm.getStartDate()));
        mySQLGroup.setEndDate(mySQLGroup.getStartDate().plusMonths(3));
        mySQLGroup.setGroupCapacity(GroupCapacity.НЕЗАПОВНЕНА);

        mySQLGroup.setEducationStatus(EducationStatus.ОЧІКУЄТЬСЯ);

        LocalDateTime timeNow = LocalDateTime.now();
        mySQLGroup.setCreatedAt(timeNow);
        mySQLGroup.setUpdatedAt(timeNow);
        mySQLService.create(mySQLGroup);

        return "redirect:/ui/v1/mysql/groups/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editGroup(Model model, @PathVariable("id") Long id){
        MySQLGroup group = mySQLService.get(id);
        GroupForm groupForm = new GroupForm();
        groupForm.setId(group.getId().toString());
        groupForm.setName(group.getName());
        groupForm.setDescription(group.getDescription());
        groupForm.setLanguage(group.getLanguage().getId() + ": " + group.getLanguage().getName());
        groupForm.setTeacher(group.getTeacher().getId() + ": " + group.getTeacher().getFullName());
        groupForm.setLevel(group.getLevel());
        List<String> languages = languageMySQLService.getAll().stream()
                .map(name -> name.getId() + ": " + name.getName())
                .collect(Collectors.toList());
        List<Level> levels = Arrays.asList(Level.values());

        List<String> teachers = teacherMySQLService.getAll().stream()
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
    public String editGroup(@PathVariable("id") Long id,
                              @ModelAttribute("group-form") GroupForm groupForm){
        MySQLGroup group = mySQLService.get(id);
        group.setName(groupForm.getName());
        group.setDescription(groupForm.getDescription());
        group.setLanguage(languageMySQLService.get(Long.valueOf(groupForm.getLanguage().split(": ")[0])));
        group.setLevel(groupForm.getLevel());
        List<Level> levels =  group.getLanguage().getLevelList();
        int startPricePerLevel =  group.getLanguage().getStartPricePerLevel();
        group.setTeacher(teacherMySQLService.get(Long.valueOf(groupForm.getTeacher().split(": ")[0])));
        group.setTotalPrice(calculateTotal(startPricePerLevel, groupForm.getLevel(), levels));
        group.setStartDate(LocalDate.parse(groupForm.getStartDate()));
        group.setEndDate(group.getStartDate().plusMonths(3));
        group.setEducationStatus(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0 ?  EducationStatus.ТРИВАЄ :
                group.getEndDate().compareTo(LocalDate.now()) < 0 ? EducationStatus.ЗАВЕРШЕНО : EducationStatus.ОЧІКУЄТЬСЯ);
        if(group.getAmountOfStudents() >= 5 && group.getStartDate().compareTo(LocalDate.now()) <= 0){
            group.setStartDate(LocalDate.now().plusDays(1));
            group.setEndDate(group.getStartDate().plusMonths(3));
        }
        mySQLService.update(group);

        return "redirect:/ui/v1/mysql/groups/";
    }

}
