package com.example.course.service.mysql.studentExam.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname IStudentExamService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/24/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLStudentExam;
import com.example.course.repository.mysql.StudentExamMySQLRepository;
import com.example.course.service.mysql.studentExam.interfaces.IStudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentExamMySQLServiceImpls implements IStudentExamService {

    @Autowired
    StudentExamMySQLRepository repository;

    @Override
    public MySQLStudentExam create(MySQLStudentExam studentExam) {
        studentExam.setCreatedAt(LocalDateTime.now());
        return repository.save(studentExam);
    }

    @Override
    public MySQLStudentExam get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MySQLStudentExam update(MySQLStudentExam exam) {
        exam.setUpdatedAt(LocalDateTime.now());
        return repository.save(exam);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MySQLStudentExam> getAll() {
        return repository.findAll();
    }

    public List<MySQLStudentExam> getStudentByCertificate(){
        return repository.getStudentByCertificate();
    }

    public int getAmountOfStudent(){
        return repository.getAmountOfStudent();
    }

    public List<Long> getExamsId(){
        return repository.getExamId();
    }
}
