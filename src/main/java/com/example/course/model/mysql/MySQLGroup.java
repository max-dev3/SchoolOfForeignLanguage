package com.example.course.model.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname MySQLGroup
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */


import com.example.course.model.mongo.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
public class MySQLGroup {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String description;
     @ManyToOne
     @JoinColumn(name = "mysqllanguage_id")
     private MySQLLanguage language;
     private Level level;
     private int totalPrice;
     private LocalDate startDate;
     private LocalDate endDate;
     private int amountOfStudents;
     @ManyToOne
     @JoinColumn(name = "mysqlteacher_id")
     private MySQLTeacher teacher;
     @Enumerated(EnumType.STRING)
     private GroupCapacity groupCapacity;
     @Enumerated(EnumType.STRING)
     private EducationStatus educationStatus;
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

     public EducationStatus getEducationStatus() {
          return educationStatus;
     }

     public void setEducationStatus(EducationStatus educationStatus) {
          this.educationStatus = educationStatus;
     }

     public void setDescription(String description) {
          this.description = description;
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

     public GroupCapacity getGroupCapacity() {
          return groupCapacity;
     }

     public void setGroupCapacity(GroupCapacity groupCapacity) {
          this.groupCapacity = groupCapacity;
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

     public MySQLLanguage getLanguage() {
          return language;
     }

     public void setLanguage(MySQLLanguage language) {
          this.language = language;
     }
}
