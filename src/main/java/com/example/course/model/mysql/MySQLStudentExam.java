package com.example.course.model.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname MySQLStudentExam
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/22/2022
 * Copyright notice
 */


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MySQLStudentExam {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String description;
     @ManyToOne
     @JoinColumn(name = "mysqlstudent_id")
     private MySQLStudent student;
     @ManyToOne
     @JoinColumn(name = "mysqlexam_id")
     private MySQLExam exam;
     private int mark;
     private boolean certificate;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;


     public MySQLStudent getStudent() {
          return student;
     }

     public void setStudent(MySQLStudent student) {
          this.student = student;
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

     public int getMark() {
          return mark;
     }

     public void setMark(int mark) {
          this.mark = mark;
     }

     public boolean isCertificate() {
          return certificate;
     }

     public void setCertificate(boolean certificate) {
          this.certificate = certificate;
     }

     public MySQLExam getExam() {
          return exam;
     }

     public void setExam(MySQLExam exam) {
          this.exam = exam;
     }
}
