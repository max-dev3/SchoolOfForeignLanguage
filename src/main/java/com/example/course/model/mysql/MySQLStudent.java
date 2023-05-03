package com.example.course.model.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname Student
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/7/2022
 * Copyright notice
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Id;

@Entity
public class MySQLStudent {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String firstName;
     private String lastName;
     private String patronymic;
     private int age;
     private String phone;
     private String email;
     private String description;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public MySQLStudent() {
     }

     public MySQLStudent(Long id, String firstName, String lastName, String patronymic, int age,
                         String phone, String email, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.firstName = firstName;
          this.lastName = lastName;
          this.patronymic = patronymic;
          this.age = age;
          this.phone = phone;
          this.email = email;
          this.description = description;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public MySQLStudent(String firstName, String lastName, String patronymic, int age, String phone,
                         String email, String description) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.patronymic = patronymic;
          this.age = age;
          this.phone = phone;
          this.email = email;
          this.description = description;
     }


     public void setId(Long id) {
          this.id = id;
     }

     public Long getId() {
          return id;
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

     public String getFullName(){
          return this.lastName + " " + this.firstName + " " +  this.patronymic;
     }

     @Override
     public int hashCode() {
          return Objects.hash(id, firstName, lastName, patronymic, age, phone, email, description, createdAt, updatedAt);
     }

     @Override
     public String toString() {
          return "Student{" +
                  "id='" + id + '\'' +
                  ", firstName='" + firstName + '\'' +
                  ", lastName='" + lastName + '\'' +
                  ", patronymic='" + patronymic + '\'' +
                  ", age=" + age +
                  ", phone='" + phone + '\'' +
                  ", email='" + email + '\'' +
                  ", description='" + description + '\'' +
                  ", createdAt=" + createdAt +
                  ", updatedAt=" + updatedAt +
                  '}';
     }

}
