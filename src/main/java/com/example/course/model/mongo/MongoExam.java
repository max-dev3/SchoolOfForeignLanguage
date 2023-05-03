package com.example.course.model.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname Exam
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 7/25/2022
 * Copyright notice
 */


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
@ApiModel
@Document
public class MongoExam {
     @Id
     @ApiModelProperty(value = "String is given by DB", required = true, dataType = "String")
     private String id;
     private String name;
     private String description;
     private MongoGroup group;
     private MongoSubject subject;
     private LocalDate dateOfExam;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public MongoExam() {
     }

     public MongoExam(String id, String name, String description,
                      MongoSubject subject,MongoGroup group, LocalDate dateOfExam,
                      LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.group = group;
          this.subject = subject;
          this.dateOfExam = dateOfExam;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public MongoExam(String name, String description, MongoGroup group, MongoSubject subject,
                      LocalDate dateOfExam) {
          this.name = name;
          this.description = description;
          this.group = group;
          this.subject = subject;
          this.dateOfExam = dateOfExam;
     }


     public MongoGroup getGroup() {
          return group;
     }

     public void setGroup(MongoGroup group) {
          this.group = group;
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

     public MongoSubject getSubject() {
          return subject;
     }

     public void setSubject(MongoSubject subject) {
          this.subject = subject;
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
}
