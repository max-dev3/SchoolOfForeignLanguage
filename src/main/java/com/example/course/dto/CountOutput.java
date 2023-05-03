package com.example.course.dto;
/*
 * author Fushtei Maksym
 * project course
 * classname CountOutput
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 10/24/2022
 * Copyright notice
 */


public class CountOutput {
     Integer age;
     Integer total;

     public CountOutput(Integer age, Integer total) {
          this.age = age;
          this.total = total;
     }

     public Integer getAge() {
          return age;
     }

     public void setAge(Integer age) {
          this.age = age;
     }

     public Integer getTotal() {
          return total;
     }

     public void setTotal(Integer total) {
          this.total = total;
     }
}
