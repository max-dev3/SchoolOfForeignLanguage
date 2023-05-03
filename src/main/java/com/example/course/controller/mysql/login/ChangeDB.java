package com.example.course.controller.mysql.login;
/*
 * author Fushtei Maksym
 * project course
 * classname ChangeDB
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/21/2022
 * Copyright notice
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ui/v1/changing/")
public class ChangeDB {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String changeDB(){
        return "change";
    }


}
