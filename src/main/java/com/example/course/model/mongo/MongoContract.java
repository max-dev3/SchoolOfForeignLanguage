package com.example.course.model.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname Contract
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 7/25/2022
 * Copyright notice
 */


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
@ApiModel
public class MongoContract {
     @Id
     @ApiModelProperty(value = "String is given by DB", required = true, dataType = "String")
     private String id;
     private String name;
     private String description;
     private MongoStudent student;
     private MongoGroup group;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public MongoContract() {
     }

     public MongoContract(String id, String name, String description,
                          MongoStudent student, MongoGroup group, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.student = student;
          this.group = group;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public MongoContract(String name, String description, MongoStudent student, MongoGroup group) {
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

     public MongoStudent getStudent() {
          return student;
     }

     public void setStudent(MongoStudent student) {
          this.student = student;
     }

     public MongoGroup getGroup() {
          return group;
     }

     public void setGroup(MongoGroup group) {
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
