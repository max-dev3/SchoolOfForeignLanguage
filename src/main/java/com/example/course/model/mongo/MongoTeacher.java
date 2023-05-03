package com.example.course.model.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname Teacher
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 7/23/2022
 * Copyright notice
 */


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
@ApiModel
public class MongoTeacher {

     @Id
     @ApiModelProperty(value = "String is given by DB", required = true, dataType = "String")
     private String id;
     private String firstName;
     private String lastName;
     private String patronymic;
     private String phone;
     private String email;
     private int experience;
     private String description;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public MongoTeacher() {
     }

     public MongoTeacher(String id, String firstName, String lastName, String patronymic, String phone,
                         String email, int experience, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.firstName = firstName;
          this.lastName = lastName;
          this.patronymic = patronymic;
          this.phone = phone;
          this.email = email;
          this.experience = experience;
          this.description = description;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public MongoTeacher(String firstName, String lastName, String patronymic, String phone,
                         String email, int experience, String description) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.patronymic = patronymic;
          this.phone = phone;
          this.email = email;
          this.experience = experience;
          this.description = description;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getFirstName() {
          return firstName;
     }

     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }

     public String getLastName() {
          return lastName;
     }

     public void setLastName(String lastName) {
          this.lastName = lastName;
     }

     public String getPatronymic() {
          return patronymic;
     }

     public void setPatronymic(String patronymic) {
          this.patronymic = patronymic;
     }

     public String getPhone() {
          return phone;
     }

     public void setPhone(String phone) {
          this.phone = phone;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public int getExperience() {
          return experience;
     }

     public void setExperience(int experience) {
          this.experience = experience;
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

     public String getFullName(){
          return this.getLastName() + " " + this.getFirstName() + " " +  this.getPatronymic();
     }
}
