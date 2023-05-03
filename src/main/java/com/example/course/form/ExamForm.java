package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname ExamForm
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */


import java.time.LocalDateTime;

public class ExamForm {
    private String id;
    private String name;
    private String description;
    private String group;
    private String subject;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ExamForm() {
    }

    public ExamForm(String id, String name, String description,
             String group, String subject, int mark, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.group = group;
        this.subject = subject;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ExamForm(String name, String description, String student, String group, String subject, int mark) {
        this.name = name;
        this.description = description;
        this.group = group;
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
