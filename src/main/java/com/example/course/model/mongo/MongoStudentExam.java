package com.example.course.model.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname MongoStudentExam
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/27/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLExam;
import com.example.course.model.mysql.MySQLStudent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@ApiModel
@Document
public class MongoStudentExam {
    @Id
    @ApiModelProperty(value = "String is given by DB", required = true, dataType = "String")
    private String id;
    private String name;
    private String description;
    private MongoStudent student;
    private MongoExam exam;
    private int mark;
    private boolean certificate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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

    public MongoStudent getStudent() {
        return student;
    }

    public void setStudent(MongoStudent student) {
        this.student = student;
    }

    public MongoExam getExam() {
        return exam;
    }

    public void setExam(MongoExam exam) {
        this.exam = exam;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean isCertificate() {
        return certificate;
    }

    public void setCertificate(boolean certificate) {
        this.certificate = certificate;
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
