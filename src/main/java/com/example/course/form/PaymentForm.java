package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname PaymentForm
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoContract;
import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mongo.MongoStudent;
import com.example.course.model.mongo.PaymentStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaymentForm {

     private String id;
     private String name;
     private String description;
     private String contract;
     private int paidAmount;
     private int remaining;
     private String payTo;
     private boolean postponePayment;
     private boolean privilege;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

     public PaymentForm() {
     }

     public PaymentForm(String id, String name, String description, String contract, int totalAmount, int paidAmount,
                        String payTo, int remaining, boolean postponePayment, boolean privilege, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.contract = contract;
          this.paidAmount = paidAmount;
          this.remaining = remaining;
          this.payTo = payTo;
          this.postponePayment = postponePayment;
          this.privilege = privilege;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public PaymentForm(String name, String description, String contract,
                        int remaining, int paidAmount, String payTo, boolean postponePayment, boolean privilege) {
          this.name = name;
          this.description = description;
          this.contract = contract;
          this.paidAmount = paidAmount;
          this.remaining = remaining;
          this.payTo = payTo;
          this.postponePayment = postponePayment;
          this.privilege = privilege;
     }

     public String getContract() {

          return contract;
     }

     public void setContract(String contract) {
          this.contract = contract;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public int getRemaining() {
          return remaining;
     }

     public void setRemaining(int remaining) {
          this.remaining = remaining;
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




     public int getPaidAmount() {
          return paidAmount;
     }

     public void setPaidAmount(int paidAmount) {
          this.paidAmount = paidAmount;
     }



     public String getPayTo() {
          return payTo;
     }

     public void setPayTo(String payTo) {
          this.payTo = payTo;
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
