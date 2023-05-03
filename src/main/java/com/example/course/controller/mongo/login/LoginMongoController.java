package com.example.course.controller.mongo.login;
/*
 * author Fushtei Maksym
 * project course
 * classname LoginMongoController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/20/2022
 * Copyright notice
 */

import com.example.course.form.UserForm;
import com.example.course.model.mongo.MongoUser;
import com.example.course.model.mysql.MySQLUser;
import com.example.course.service.mongo.user.impls.UserMongoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ui/v1/mongo/")
public class LoginMongoController {

     @Autowired
     UserMongoServiceImpl userMongoService;

     @RequestMapping(value = "login/", method = RequestMethod.GET)
     public String loginPage(Model model){
          UserForm userForm = new UserForm();
          model.addAttribute("user-form", userForm);
          model.addAttribute("error", "");
          model.addAttribute("dbname", "mongo");

          return "login";
     }

     @RequestMapping(value = "login/", method = RequestMethod.POST)
     public String loginPage(@ModelAttribute("user-form") UserForm userForm, Model model){
          MongoUser user = userMongoService.getByEmail(userForm.getEmail());
          if(user != null){
               if(user.getPassword().equals(userForm.getPassword())){
                    model.addAttribute("dbname", "mongo");
                    return "redirect:/ui/v1/mongo/main/";
               }
               else{
                    model.addAttribute("error", "Невірний пароль!");
                    model.addAttribute("dbname", "mongo");
                    return "login";
               }
          }
          else {
               model.addAttribute("error", "Користувача не знайдено!");
               model.addAttribute("dbname", "mongo");
               return "login";
          }
     }

     @GetMapping("main/")
     public String showPage(Model model){
          model.addAttribute("dbname", "mongo");
          return "index";
     }

     @RequestMapping(value = "registration/", method = RequestMethod.GET)
     public String addUser(Model model){
          UserForm userForm = new UserForm();
          model.addAttribute("user-form", userForm);
          model.addAttribute("error", "");
          model.addAttribute("dbname", "mongo");
          return "registration";
     }

     @RequestMapping(value = "registration/", method = RequestMethod.POST)
     public String addUser(@ModelAttribute("user-form") UserForm userForm, Model model){
          if(userMongoService.getByEmail(userForm.getEmail()) == null) {
               MongoUser user = new MongoUser();
               user.setEmail(userForm.getEmail());
               user.setPassword(userForm.getPassword());
               userMongoService.create(user);
               return "redirect:/ui/v1/mongo/login/";
          }
          else{
               model.addAttribute("error", "Користувач з таким email вже існує!");
               model.addAttribute("dbname", "mongo");
               return "registration";
          }
     }

     @RequestMapping(value = "forgot/", method = RequestMethod.GET)
     public String forgotPassword(Model model){
          UserForm userForm = new UserForm();
          model.addAttribute("user-form", userForm);
          model.addAttribute("password", "");
          model.addAttribute("error", "");
          model.addAttribute("dbname", "mongo");
          return "forgot";
     }

     @RequestMapping(value = "forgot/", method = RequestMethod.POST)
     public String forgotPassword(@ModelAttribute("user-form") UserForm userForm, Model model){
          MongoUser user = userMongoService.getByEmail(userForm.getEmail());
          if(user == null) {
               model.addAttribute("error", "Користувача не знайдено!");
               model.addAttribute("password", "");
               model.addAttribute("dbname", "mongo");
               return "forgot";
          }
          else {
               model.addAttribute("password", "Пароль: " + user.getPassword());
               model.addAttribute("error", "");
               model.addAttribute("dbname", "mongo");
               return "forgot";
          }
     }
}
