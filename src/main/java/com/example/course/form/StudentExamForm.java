package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentExam
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/24/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLExam;

import java.time.LocalDateTime;

public class StudentExamForm {
     private String id;
     private String name;
     private String description;
     private String exam;
     private String student;
     private int mark;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public String getStudent() {
          return student;
     }

     public void setStudent(String student) {
          this.student = student;
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

     public String getExam() {
          return exam;
     }

     public void setExam(String exam) {
          this.exam = exam;
     }

     public int getMark() {
          return mark;
     }

     public void setMark(int mark) {
          this.mark = mark;
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
