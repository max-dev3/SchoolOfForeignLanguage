package com.example.course.model.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname MySQLPayment
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mongo.MongoStudent;
import com.example.course.model.mongo.PaymentStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
public class MySQLPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name = "mysqlcontract_id")
    private MySQLContract contract;
    private int totalAmount;
    private int paidAmount;
    private LocalDate paidAt;
    private LocalDate payTo;
    private PaymentStatus paymentStatus;
    private boolean postponePayment;
    private boolean privilege;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public LocalDate getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDate paidAt) {
        this.paidAt = paidAt;
    }

    public LocalDate getPayTo() {
        return payTo;
    }

    public void setPayTo(LocalDate payTo) {
        this.payTo = payTo;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    public MySQLContract getContract() {
        return contract;
    }

    public void setContract(MySQLContract contract) {
        this.contract = contract;
    }
}
