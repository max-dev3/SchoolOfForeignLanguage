package com.example.course.service.mysql.student.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentServiceImpl
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/7/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoStudent;
import com.example.course.model.mysql.MySQLStudent;
import com.example.course.repository.mysql.StudentMySQLRepository;
import com.example.course.service.mysql.student.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentMySQLServiceImpl implements IStudentService {


     @Autowired
     StudentMySQLRepository repository;


     @Override
     public MySQLStudent create(MySQLStudent student) {
          student.setCreatedAt(LocalDateTime.now());
          return repository.save(student);
     }

     @Override
     public MySQLStudent get(Long id) {
          return repository.findById(id).orElse(null);
     }

     @Override
     public MySQLStudent update(MySQLStudent student) {
          student.setUpdatedAt(LocalDateTime.now());
          return repository.save(student);
     }

     @Override
     public void delete(Long id) {
          repository.deleteById(id);
     }

     @Override
     public List<MySQLStudent> getAll() {
          return repository.findAll();
     }

     public List<MySQLStudent> getAllByStr(String name){
          return repository.findByFirstNameContainingIgnoreCase(name);
     }
     public List<MySQLStudent> getStudentByPageListed(int size, int page){
          return repository.findAll(PageRequest.of(page, size)).getContent();
     }
}
