package com.example.course.controller.mongo.language;
/*
 * author Fushtei Maksym
 * project course
 * classname LanguageUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/10/2022
 * Copyright notice
 */

import com.example.course.form.GroupForm;
import com.example.course.form.LanguageForm;
import com.example.course.model.mongo.Level;
import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mongo.MongoLanguage;
import com.example.course.service.mongo.language.impls.LanguageMongoServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/mongo/languages")
public class LanguageUIController {

    @Autowired
    LanguageMongoServiceImpls service;

    @GetMapping("/")
    public String showAll(Model model){
        List<MongoLanguage> list = service.getAll();

        model.addAttribute("languages", list);
        model.addAttribute("dbname", "mongo");
        return "languages-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongo/languages/";
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addLanguage(Model model){
        LanguageForm languageForm = new LanguageForm();

        List<Level> levels = Arrays.asList(Level.values());

        model.addAttribute("language-form", languageForm);
        model.addAttribute("levels", levels);
        return "add-language";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addGroup(@RequestParam String name, @RequestParam String description,
                           @RequestParam(value = "firstCheckbox", defaultValue = "false") boolean firstCheckbox,
                           @RequestParam(value = "secondCheckbox", defaultValue = "false") boolean secondCheckbox,
                           @RequestParam(value = "thirdCheckbox", defaultValue = "false") boolean thirdCheckbox,
                           @RequestParam(value = "fourthCheckbox", defaultValue = "false") boolean fourthCheckbox,
                           @RequestParam(value = "fifthCheckbox", defaultValue = "false") boolean fifthCheckbox,
                           @RequestParam(value = "sixthCheckbox", defaultValue = "false") boolean sixthCheckbox,
                           @RequestParam int startPrice){
        List<Level> levelList = new ArrayList<>();

        MongoLanguage mongoLanguage = new MongoLanguage();
        mongoLanguage.setName(name);
        mongoLanguage.setDescription(description);

        if(firstCheckbox){
            levelList.add(Level.A1);
        }
        if(secondCheckbox){
            levelList.add(Level.A2);
        }
        if(thirdCheckbox){
            levelList.add(Level.B1);
        }
        if(fourthCheckbox){
            levelList.add(Level.B2);
        }
        if(fifthCheckbox){
            levelList.add(Level.C1);
        }
        if(sixthCheckbox){
            levelList.add(Level.C2);
        }
        mongoLanguage.setLevelList(levelList);
        mongoLanguage.setStartPricePerLevel(startPrice);
        LocalDateTime timeNow = LocalDateTime.now();
        mongoLanguage.setCreatedAt(timeNow);
        mongoLanguage.setUpdatedAt(timeNow);
        service.create(mongoLanguage);

        return "redirect:/ui/v1/mongo/languages/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTeacher(Model model, @PathVariable("id") String id){
        MongoLanguage language = service.get(id);
        LanguageForm languageForm = new LanguageForm();
        languageForm.setId(language.getId());
        languageForm.setName(language.getName());
        languageForm.setDescription(language.getDescription());
        languageForm.setStartPricePerLevel(language.getStartPricePerLevel());

        languageForm.setCreatedAt(language.getCreatedAt());
        model.addAttribute("language-form", languageForm);

        return "edit-language";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editTeacher(@PathVariable("id") String id,
                              @ModelAttribute("language-form") LanguageForm languageForm,
                              @RequestParam(value = "firstCheckbox", defaultValue = "false") boolean firstCheckbox,
                              @RequestParam(value = "secondCheckbox", defaultValue = "false") boolean secondCheckbox,
                              @RequestParam(value = "thirdCheckbox", defaultValue = "false") boolean thirdCheckbox,
                              @RequestParam(value = "fourthCheckbox", defaultValue = "false") boolean fourthCheckbox,
                              @RequestParam(value = "fifthCheckbox", defaultValue = "false") boolean fifthCheckbox,
                              @RequestParam(value = "sixthCheckbox", defaultValue = "false") boolean sixthCheckbox){
        MongoLanguage language = service.get(id);
        language.setName(languageForm.getName());
        language.setDescription(languageForm.getDescription());
        language.setStartPricePerLevel(languageForm.getStartPricePerLevel());
        List<Level> levelList = new ArrayList<>();

        if(firstCheckbox){
            levelList.add(Level.A1);
        }
        if(secondCheckbox){
            levelList.add(Level.A2);
        }
        if(thirdCheckbox){
            levelList.add(Level.B1);
        }
        if(fourthCheckbox){
            levelList.add(Level.B2);
        }
        if(fifthCheckbox){
            levelList.add(Level.C1);
        }
        if(sixthCheckbox){
            levelList.add(Level.C2);
        }
        language.setLevelList(levelList);
        service.update(language);
        return "redirect:/ui/v1/mongo/languages/";
    }


}
