package com.example.course.model.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname MySQLContract
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mongo.MongoStudent;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class MySQLContract {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String description;
     @OneToOne
     @JoinColumn(name = "mysqlstudent_id")
     private MySQLStudent student;
     @ManyToOne
     @JoinColumn(name = "mysqlgroup_id")
     private MySQLGroup group;
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

     public MySQLGroup getGroup() {
          return group;
     }

     public void setGroup(MySQLGroup group) {
          this.group = group;
     }

     public MySQLStudent getStudent() {
          return student;
     }

     public void setStudent(MySQLStudent student) {
          this.student = student;
     }
}
