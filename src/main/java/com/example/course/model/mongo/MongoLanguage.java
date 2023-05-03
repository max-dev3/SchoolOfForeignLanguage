package com.example.course.model.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname MongoLanguage
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/10/2022
 * Copyright notice
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@ApiModel
@Document
public class MongoLanguage {

     @Id
     @ApiModelProperty(value = "String is given by DB", required = true, dataType = "String")
     private String id;
     private String name;
     private String description;
     private List<Level> levelList;
     private int startPricePerLevel;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public MongoLanguage() {
     }

     public MongoLanguage(String id, String name, String description, List<Level> levelList,
                          int startPricePerLevel, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.levelList = levelList;
          this.startPricePerLevel = startPricePerLevel;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public MongoLanguage(String name, String description, List<Level> levelList, int startPricePerLevel) {
          this.name = name;
          this.description = description;
          this.levelList = levelList;
          this.startPricePerLevel = startPricePerLevel;
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

     public List<Level> getLevelList() {
          return levelList;
     }

     public void setLevelList(List<Level> levelList) {
          this.levelList = levelList;
     }

     public int getStartPricePerLevel() {
          return startPricePerLevel;
     }

     public void setStartPricePerLevel(int startPricePerLevel) {
          this.startPricePerLevel = startPricePerLevel;
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


     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          MongoLanguage that = (MongoLanguage) o;
          return startPricePerLevel == that.startPricePerLevel && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(levelList, that.levelList) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
     }

     @Override
     public int hashCode() {
          return Objects.hash(id, name, description, levelList, startPricePerLevel, createdAt, updatedAt);
     }
}
