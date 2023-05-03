package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname GroupForm
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/9/2022
 * Copyright notice
 */


import com.example.course.model.mongo.Level;

import java.time.LocalDateTime;

public class GroupForm {
     private String id;
     private String name;
     private String description;
     private String language;
     private Level level;
     private String startDate;
     private int amountOfStudents;
     private String teacher;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public GroupForm() {
     }

     public GroupForm(String id, String name, String description, String language, Level level,String startDate,
                      int amountOfStudents, String teacher, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.language = language;
          this.level = level;
          this.startDate = startDate;
          this.amountOfStudents = amountOfStudents;
          this.teacher = teacher;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public GroupForm(String name, String description, String language, Level level,
                      String startDate, int amountOfStudents, String teacher) {
          this.name = name;
          this.description = description;
          this.language = language;
          this.level = level;
          this.startDate = startDate;
          this.amountOfStudents = amountOfStudents;
          this.teacher = teacher;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getLanguage() {
          return language;
     }

     public void setLanguage(String language) {
          this.language = language;
     }

     public Level getLevel() {
          return level;
     }

     public void setLevel(Level level) {
          this.level = level;
     }

     public String getStartDate() {
          return startDate;
     }

     public void setStartDate(String startDate) {
          this.startDate = startDate;
     }

     public int getAmountOfStudents() {
          return amountOfStudents;
     }

     public void setAmountOfStudents(int amountOfStudents) {
          this.amountOfStudents = amountOfStudents;
     }

     public String getTeacher() {
          return teacher;
     }

     public void setTeacher(String teacher) {
          this.teacher = teacher;
     }

     public LocalDateTime getCreatedAt() {
          return createdAt;
     }

     public void setCreatedAt(LocalDateTime createdAt) {
          this.createdAt = createdAt;
     }

     public LocalDateTime getUpdatedAt() {
          return updatedAt;
     }

     public void setUpdatedAt(LocalDateTime updatedAt) {
          this.updatedAt = updatedAt;
     }
}
