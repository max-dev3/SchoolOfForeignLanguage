package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname NewStudentContract
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/19/2022
 * Copyright notice
 */


import java.time.LocalDateTime;

public class NewStudentContract {
     private String id;
     private String firstName;
     private String lastName;
     private String patronymic;
     private int age;
     private String phone;
     private String email;
     private String description;
     private String group;
     private boolean postponePayment;
     private boolean privilege;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

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

     public int getAge() {
          return age;
     }

     public void setAge(int age) {
          this.age = age;
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

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getGroup() {
          return group;
     }

     public void setGroup(String group) {
          this.group = group;
     }

     public boolean isPostponePayment() {
          return postponePayment;
     }

     public void setPostponePayment(boolean postponePayment) {
          this.postponePayment = postponePayment;
     }

     public boolean isPrivilege() {
          return privilege;
     }

     public void setPrivilege(boolean privilege) {
          this.privilege = privilege;
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
