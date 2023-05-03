package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname ContractForm
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mongo.MongoStudent;

import java.time.LocalDateTime;

public class ContractForm {
     private String id;
     private String name;
     private String description;
     private String student;
     private String group;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public ContractForm() {
     }

     public ContractForm(String id, String name,
                         String description, String student, String group, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.student = student;
          this.group = group;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public ContractForm(String name, String description, String student, String group) {
          this.name = name;
          this.description = description;
          this.student = student;
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

     public String getStudent() {
          return student;
     }

     public void setStudent(String student) {
          this.student = student;
     }

     public String getGroup() {
          return group;
     }

     public void setGroup(String group) {
          this.group = group;
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
