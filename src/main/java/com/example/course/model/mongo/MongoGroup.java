package com.example.course.model.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname Group
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 7/23/2022
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
public class MongoGroup {

     @Id
     @ApiModelProperty(value = "String is given by DB", required = true, dataType = "String")
     private String id;
     private String name;
     private String description;
     private MongoLanguage language;
     private Level level;
     private int totalPrice;
     private LocalDate startDate;
     private LocalDate endDate;
     private int amountOfStudents;
     private MongoTeacher teacher;
     private GroupCapacity groupCapacity;
     private EducationStatus educationStatus;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public MongoGroup() {
     }

     public MongoGroup(String id, String name, String description, MongoLanguage language, Level level, int totalPrice, LocalDate startDate,
                       LocalDate endDate, int amountOfStudents, MongoTeacher teacher, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.language = language;
          this.level = level;
          this.totalPrice = totalPrice;
          this.startDate = startDate;
          this.endDate = endDate;
          this.amountOfStudents = amountOfStudents;
          this.teacher = teacher;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public MongoGroup(String name, String description, MongoLanguage language,
                       Level level, int totalPrice, LocalDate startDate, LocalDate endDate, int amountOfStudents, MongoTeacher teacher) {
          this.name = name;
          this.description = description;
          this.language = language;
          this.level = level;
          this.totalPrice = totalPrice;
          this.startDate = startDate;
          this.endDate = endDate;
          this.amountOfStudents = amountOfStudents;
          this.teacher = teacher;
     }

     public EducationStatus getEducationStatus() {
          return educationStatus;
     }

     public void setEducationStatus(EducationStatus educationStatus) {
          this.educationStatus = educationStatus;
     }

     public GroupCapacity getGroupCapacity() {
          return groupCapacity;
     }

     public void setGroupCapacity(GroupCapacity groupCapacity) {
          this.groupCapacity = groupCapacity;
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

     public MongoLanguage getLanguage() {
          return language;
     }

     public void setLanguage(MongoLanguage language) {
          this.language = language;
     }

     public Level getLevel() {
          return level;
     }

     public void setLevel(Level level) {
          this.level = level;
     }

     public int getTotalPrice() {
          return totalPrice;
     }

     public void setTotalPrice(int totalPrice) {
          this.totalPrice = totalPrice;
     }

     public LocalDate getStartDate() {
          return startDate;
     }

     public void setStartDate(LocalDate startDate) {
          this.startDate = startDate;
     }

     public LocalDate getEndDate() {
          return endDate;
     }

     public void setEndDate(LocalDate endDate) {
          this.endDate = endDate;
     }

     public int getAmountOfStudents() {
          return amountOfStudents;
     }

     public void setAmountOfStudents(int amountOfStudents) {
          this.amountOfStudents = amountOfStudents;
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
