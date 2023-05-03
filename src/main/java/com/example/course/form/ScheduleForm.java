package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname ScheduleForm
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */


import com.example.course.model.mongo.Day;
import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mongo.MongoSubject;
import com.example.course.model.mongo.MongoTeacher;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ScheduleForm {

     private String id;
     private Day day;
     private String group;
     private int classroom;
     private String startLesson;
     private String subject;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public ScheduleForm() {
     }

     public ScheduleForm(String id, Day day, String group,
                         int classroom, String startLesson, String subject, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.day = day;
          this.group = group;
          this.classroom = classroom;
          this.startLesson = startLesson;
          this.subject = subject;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public ScheduleForm(Day day, String group, int classroom, String startLesson, String subject) {
          this.day = day;
          this.group = group;
          this.classroom = classroom;
          this.startLesson = startLesson;
          this.subject = subject;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public Day getDay() {
          return day;
     }

     public void setDay(Day day) {
          this.day = day;
     }

     public String getGroup() {
          return group;
     }

     public void setGroup(String group) {
          this.group = group;
     }

     public int getClassroom() {
          return classroom;
     }

     public void setClassroom(int classroom) {
          this.classroom = classroom;
     }

     public String getStartLesson() {
          return startLesson;
     }

     public void setStartLesson(String startLesson) {
          this.startLesson = startLesson;
     }

     public String getSubject() {
          return subject;
     }

     public void setSubject(String subject) {
          this.subject = subject;
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
