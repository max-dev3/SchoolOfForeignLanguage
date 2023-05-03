package com.example.course.model.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname Schedule
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 7/25/2022
 * Copyright notice
 */


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.LocalTime;
@ApiModel
@Document
public class MongoSchedule {
     @Id
     @ApiModelProperty(value = "String is given by DB", required = true, dataType = "String")
     private String id;
     private String name;
     private String description;
     private Day day;
     private MongoGroup group;
     private int classroom;
     private LocalTime startLesson;
     private LocalTime endLesson;
     private MongoSubject subject;
     private MongoTeacher teacher;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public MongoSchedule() {
     }

     public MongoSchedule(String id, String name, String description, Day day, MongoGroup group, int classroom, LocalTime startLesson,
                          LocalTime endLesson, MongoSubject subject, MongoTeacher teacher, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.day = day;
          this.group = group;
          this.classroom = classroom;
          this.startLesson = startLesson;
          this.endLesson = endLesson;
          this.subject = subject;
          this.teacher = teacher;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public MongoSchedule(String name, String description, Day day,
                          MongoGroup group, int classroom, LocalTime startLesson, LocalTime endLesson, MongoSubject subject, MongoTeacher teacher) {

          this.name = name;
          this.description = description;
          this.day = day;
          this.group = group;
          this.classroom = classroom;
          this.startLesson = startLesson;
          this.endLesson = endLesson;
          this.subject = subject;
          this.teacher = teacher;
     }

     public MongoSchedule(Day day, MongoGroup group, int classroom, LocalTime startLesson, LocalTime endLesson, MongoSubject subject) {
          this.day = day;
          this.group = group;
          this.classroom = classroom;
          this.startLesson = startLesson;
          this.endLesson = endLesson;
          this.subject = subject;
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

     public Day getDay() {
          return day;
     }

     public void setDay(Day day) {
          this.day = day;
     }

     public MongoGroup getGroup() {
          return group;
     }

     public void setGroup(MongoGroup group) {
          this.group = group;
     }

     public int getClassroom() {
          return classroom;
     }

     public void setClassroom(int classroom) {
          this.classroom = classroom;
     }

     public LocalTime getStartLesson() {
          return startLesson;
     }

     public void setStartLesson(LocalTime startLesson) {
          this.startLesson = startLesson;
     }

     public LocalTime getEndLesson() {
          return endLesson;
     }

     public void setEndLesson(LocalTime endLesson) {
          this.endLesson = endLesson;
     }

     public MongoSubject getSubject() {
          return subject;
     }

     public void setSubject(MongoSubject subject) {
          this.subject = subject;
     }

     public MongoTeacher getTeacher() {
          return teacher;
     }

     public void setTeacher(MongoTeacher teacher) {
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
