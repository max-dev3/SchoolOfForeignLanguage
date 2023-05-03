package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentForm
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/6/2022
 * Copyright notice
 */


import java.time.LocalDateTime;
import java.util.Objects;

public class StudentForm {
     private String id;
     private String firstName;
     private String lastName;
     private String patronymic;
     private int age;
     private String phone;
     private String email;
     private String description;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public StudentForm() {
     }

     public StudentForm(String id, String firstName, String lastName, String patronymic, int age,
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

     public StudentForm(String firstName, String lastName, String patronymic, int age, String phone,
                    String email, String description) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.patronymic = patronymic;
          this.age = age;
          this.phone = phone;
          this.email = email;
          this.description = description;
     }

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
