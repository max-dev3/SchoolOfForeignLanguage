package com.example.course.dto;
/*
 * author Fushtei Maksym
 * project course
 * classname SumOutput
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 10/24/2022
 * Copyright notice
 */


import io.swagger.models.auth.In;

public class SumOutput {
     String id;
     Integer agePerName;

     public SumOutput(String id, Integer agePerName) {
          this.id = id;
          this.agePerName = agePerName;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public Integer getAgePerName() {
          return agePerName;
     }

     public void setAgePerName(Integer agePerName) {
          this.agePerName = agePerName;
     }
}
