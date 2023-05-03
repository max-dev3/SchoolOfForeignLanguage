package com.example.course.model.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname MySQLExam
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mongo.MongoStudent;
import com.example.course.model.mongo.MongoSubject;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
public class MySQLExam {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String description;

     @ManyToOne
     @JoinColumn(name = "mysqlgroup_id")
     private MySQLGroup group;
     @OneToOne
     @JoinColumn(name = "mysqlsubject_id")
     private MySQLSubject subject;
     private LocalDate dateOfExam;

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

     public LocalDate getDateOfExam() {
          return dateOfExam;
     }

     public void setDateOfExam(LocalDate dateOfExam) {
          this.dateOfExam = dateOfExam;
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
