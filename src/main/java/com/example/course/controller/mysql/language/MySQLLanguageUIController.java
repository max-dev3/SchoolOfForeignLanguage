package com.example.course.controller.mysql.language;
/*
 * author Fushtei Maksym
 * project course
 * classname LanguageUIController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/10/2022
 * Copyright notice
 */

import com.example.course.form.LanguageForm;
import com.example.course.model.mongo.Level;
import com.example.course.model.mysql.MySQLLanguage;
import com.example.course.service.mysql.language.impls.LanguageMySQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/mysql/languages")
public class MySQLLanguageUIController {

    @Autowired
    LanguageMySQLServiceImpl service;

    @GetMapping("/")
    public String showAll(Model model){
        List<MySQLLanguage> list = service.getAll();

        model.addAttribute("languages", list);
        model.addAttribute("dbname", "mysql");
        return "languages-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/ui/v1/mysql/languages/";
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
    public String addLanguage(@ModelAttribute("language-form") LanguageForm languageForm,
                              @RequestParam String name, @RequestParam String description,
                           @RequestParam(value = "firstCheckbox", defaultValue = "false") boolean firstCheckbox,
                           @RequestParam(value = "secondCheckbox", defaultValue = "false") boolean secondCheckbox,
                           @RequestParam(value = "thirdCheckbox", defaultValue = "false") boolean thirdCheckbox,
                           @RequestParam(value = "fourthCheckbox", defaultValue = "false") boolean fourthCheckbox,
                           @RequestParam(value = "fifthCheckbox", defaultValue = "false") boolean fifthCheckbox,
                           @RequestParam(value = "sixthCheckbox", defaultValue = "false") boolean sixthCheckbox,
                           @RequestParam int startPrice){
        List<Level> levelList = new ArrayList<>();

        MySQLLanguage mySQLLanguage = new MySQLLanguage();
        mySQLLanguage.setName(name);
        mySQLLanguage.setDescription(description);

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
        mySQLLanguage.setLevelList(levelList);
        mySQLLanguage.setStartPricePerLevel(startPrice);
        LocalDateTime timeNow = LocalDateTime.now();
        mySQLLanguage.setCreatedAt(timeNow);
        mySQLLanguage.setUpdatedAt(timeNow);
        service.create(mySQLLanguage);

        return "redirect:/ui/v1/mysql/languages/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editLanguage(Model model, @PathVariable("id") Long id){
        MySQLLanguage language = service.get(id);
        LanguageForm languageForm = new LanguageForm();
        languageForm.setId(language.getId().toString());
        languageForm.setName(language.getName());
        languageForm.setDescription(language.getDescription());
        languageForm.setStartPricePerLevel(language.getStartPricePerLevel());

        languageForm.setCreatedAt(language.getCreatedAt());
        model.addAttribute("language-form", languageForm);

        return "edit-language";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editLanguage(@PathVariable("id") Long id,
                              @ModelAttribute("language-form") LanguageForm languageForm,
                               @RequestParam String name, @RequestParam String description,
                              @RequestParam(value = "firstCheckbox", defaultValue = "false") boolean firstCheckbox,
                              @RequestParam(value = "secondCheckbox", defaultValue = "false") boolean secondCheckbox,
                              @RequestParam(value = "thirdCheckbox", defaultValue = "false") boolean thirdCheckbox,
                              @RequestParam(value = "fourthCheckbox", defaultValue = "false") boolean fourthCheckbox,
                              @RequestParam(value = "fifthCheckbox", defaultValue = "false") boolean fifthCheckbox,
                              @RequestParam(value = "sixthCheckbox", defaultValue = "false") boolean sixthCheckbox,
                               @RequestParam int startPrice){
        MySQLLanguage language = service.get(id);
        language.setName(name);
        language.setDescription(description);
        language.setStartPricePerLevel(startPrice);
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
        return "redirect:/ui/v1/mysql/languages/";
    }


}
