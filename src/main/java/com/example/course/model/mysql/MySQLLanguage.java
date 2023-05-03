package com.example.course.model.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname MySQLLanguage
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */


import com.example.course.model.mongo.Level;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class MySQLLanguage {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String description;
     @ElementCollection(targetClass=Level.class)
     @Enumerated(EnumType.STRING) // Possibly optional (I'm not sure) but defaults to ORDINAL.
     private List<Level> levelList;
     private int startPricePerLevel;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public MySQLLanguage() {
     }

     public MySQLLanguage(Long id, String name, String description,
                          List<Level> levelList, int startPricePerLevel, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.levelList = levelList;
          this.startPricePerLevel = startPricePerLevel;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

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
}
