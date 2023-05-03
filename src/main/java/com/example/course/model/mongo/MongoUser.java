package com.example.course.model.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname MongoUser
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/20/2022
 * Copyright notice
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MongoUser {

     @Id
     private String id;
     private String email;
     private String password;

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }
}
