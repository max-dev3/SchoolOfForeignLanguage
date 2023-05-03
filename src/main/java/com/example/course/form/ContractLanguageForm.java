package com.example.course.form;
/*
 * author Fushtei Maksym
 * project course
 * classname ContractLanguageForm
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/19/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLLanguage;

import java.time.LocalDateTime;
import java.util.List;

public class ContractLanguageForm {
    private Long id;
    private String student;
    private List<MySQLLanguage> languages;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public List<MySQLLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(List<MySQLLanguage> languages) {
        this.languages = languages;
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
