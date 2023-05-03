package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname QueryForm
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/11/2022
 * Copyright notice
 */


public class QueryForm {
     private String language;
     private String teacher;
     private String group;

     public String getGroup() {
          return group;
     }

     public void setGroup(String group) {
          this.group = group;
     }

     public String getTeacher() {
          return teacher;
     }

     public void setTeacher(String teacher) {
          this.teacher = teacher;
     }

     public String getLanguage() {
          return language;
     }

     public void setLanguage(String language) {
          this.language = language;
     }
}
