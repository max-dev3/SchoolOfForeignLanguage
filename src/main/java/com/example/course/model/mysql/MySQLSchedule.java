package com.example.course.model.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname MySQLSchedule
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */


import com.example.course.model.mongo.Day;
import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mongo.MongoSubject;
import com.example.course.model.mongo.MongoTeacher;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Entity
public class MySQLSchedule {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String description;
     @Enumerated(EnumType.STRING)
     private Day day;
     @OneToOne
     @JoinColumn(name = "mysqlgroup_id")
     private MySQLGroup group;
     private int classroom;
     private LocalTime startLesson;
     private LocalTime endLesson;
     @OneToOne
     @JoinColumn(name = "mysqlsubject_id")
     private MySQLSubject subject;
     @OneToOne
     @JoinColumn(name = "mysqlteacher_id")
     private MySQLTeacher teacher;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
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

     public MySQLTeacher getTeacher() {
          return teacher;
     }

     public void setTeacher(MySQLTeacher teacher) {
          this.teacher = teacher;
     }

     public MySQLSubject getSubject() {
          return subject;
     }

     public void setSubject(MySQLSubject subject) {
          this.subject = subject;
     }

     public MySQLGroup getGroup() {
          return group;
     }

     public void setGroup(MySQLGroup group) {
          this.group = group;
     }
}
