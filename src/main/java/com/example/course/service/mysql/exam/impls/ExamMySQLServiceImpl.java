package com.example.course.service.mysql.exam.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname ExamMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLExam;
import com.example.course.repository.mysql.ExamMySQLRepository;
import com.example.course.service.mysql.exam.interfaces.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ExamMySQLServiceImpl implements IExamService {

     @Autowired
     ExamMySQLRepository repository;

     @Override
     public MySQLExam create(MySQLExam exam) {
          exam.setCreatedAt(LocalDateTime.now());
          return repository.save(exam);
     }

     @Override
     public MySQLExam get(Long id) {
          return repository.findById(id).orElse(null);
     }

     @Override
     public MySQLExam update(MySQLExam exam) {
          exam.setUpdatedAt(LocalDateTime.now());
          return repository.save(exam);
     }

     @Override
     public void delete(Long id) {
          repository.deleteById(id);
     }

     @Override
     public List<MySQLExam> getAll() {
          return repository.findAll();
     }
}
