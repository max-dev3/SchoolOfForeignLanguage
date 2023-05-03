package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname SubjectForm
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/17/2022
 * Copyright notice
 */


import java.time.LocalDateTime;

public class SubjectForm {
     private String id;
     private String name;
     private String description;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public SubjectForm() {
     }

     public SubjectForm(String id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
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
