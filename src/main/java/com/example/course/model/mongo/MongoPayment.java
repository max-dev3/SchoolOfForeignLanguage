package com.example.course.model.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname Payment
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 7/25/2022
 * Copyright notice
 */


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
@ApiModel
@Document
public class MongoPayment {
    @Id
    @ApiModelProperty(value = "String is given by DB", required = true, dataType = "String")
    private String id;
    private String name;
    private String description;
    private MongoContract contract;
    private int totalAmount;
    private int paidAmount;
    private LocalDate paidAt;
    private LocalDate payTo;
    private PaymentStatus paymentStatus;
    private boolean postponePayment;
    private boolean privilege;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MongoPayment() {
    }

    public MongoPayment(String id, String name, String description, MongoContract contract,  int totalAmount, int paidAmount, LocalDate paidAt, LocalDate payTo,
                        PaymentStatus paymentStatus, boolean postponePayment, boolean privilege, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.contract = contract;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.paidAt = paidAt;
        this.payTo = payTo;
        this.paymentStatus = paymentStatus;
        this.postponePayment = postponePayment;
        this.privilege = privilege;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public MongoPayment(String name, String description, MongoContract contract, int totalAmount, int paidAmount,
                        LocalDate paidAt, LocalDate payTo, PaymentStatus paymentStatus, boolean postponePayment, boolean privilege) {
        this.name = name;
        this.description = description;
        this.contract = contract;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.paidAt = paidAt;
        this.payTo = payTo;
        this.paymentStatus = paymentStatus;
        this.postponePayment = postponePayment;
        this.privilege = privilege;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public MongoContract getContract() {
        return contract;
    }

    public void setContract(MongoContract contract) {
        this.contract = contract;
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
}
