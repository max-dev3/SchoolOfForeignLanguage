package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname LanguageForm
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/10/2022
 * Copyright notice
 */


import com.example.course.model.mongo.Level;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class LanguageForm {

     private String id;
     private String name;
     private String description;
     private Level level;
     private Level secondLevel;
     private Level thirdLevel;

     private int startPricePerLevel;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public LanguageForm() {
     }

//     public LanguageForm(String id, String name, String description,
//                         LinkedHashMap<String, Level>  levelList, int startPricePerLevel, LocalDateTime createdAt, LocalDateTime updatedAt) {
//          this.id = id;
//          this.name = name;
//          this.description = description;
//          this.levelList = levelList;
//          this.startPricePerLevel = startPricePerLevel;
//          this.createdAt = createdAt;
//          this.updatedAt = updatedAt;
//     }
//
//     public LanguageForm(String name, String description, LinkedHashMap<String, Level>  levelList, int startPricePerLevel) {
//          this.name = name;
//          this.description = description;
//          this.levelList = levelList;
//          this.startPricePerLevel = startPricePerLevel;
//     }


     public LanguageForm(String id, String name, String description, Level level, int startPricePerLevel, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.level = level;
          this.startPricePerLevel = startPricePerLevel;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public Level getSecondLevel() {
          return secondLevel;
     }

     public void setSecondLevel(Level secondLevel) {
          this.secondLevel = secondLevel;
     }

     public Level getThirdLevel() {
          return thirdLevel;
     }

     public void setThirdLevel(Level thirdLevel) {
          this.thirdLevel = thirdLevel;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public Level getLevel() {
          return level;
     }

     public void setLevel(Level level) {
          this.level = level;
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

//     public List<Level> getLevelList() {
//          return levelList;
//     }
//
//     public void setLevelList(List<Level> levelList) {
//          this.levelList = levelList;
//     }

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
