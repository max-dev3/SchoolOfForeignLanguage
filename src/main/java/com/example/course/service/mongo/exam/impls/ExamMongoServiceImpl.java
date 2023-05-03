package com.example.course.service.mongo.exam.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname ExamMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */


import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoExam;
import com.example.course.repository.mongo.ExamMongoRepository;
import com.example.course.service.mongo.exam.interfaces.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ExamMongoServiceImpl implements IExamService {

     @Autowired
     ExamMongoRepository repository;

     @Override
     public MongoExam create(MongoExam exam) {
          exam.setCreatedAt(LocalDateTime.now());
          return repository.save(exam);
     }

     @Override
     public MongoExam get(String id) {
          return repository.findById(id).orElseThrow( () -> new ApiRequestException("Не знайдено з таким id - " + id));
     }

     @Override
     public MongoExam update(MongoExam exam) {
          exam.setUpdatedAt(LocalDateTime.now());
          return repository.save(exam);
     }

     @Override
     public void delete(String id) {
          if(!repository.existsById(id)){
               throw new ApiRequestException("Не знайдено з таким id - " + id);
          }
          repository.deleteById(id);
     }

     @Override
     public List<MongoExam> getAll() {
          return repository.findAll();
     }
}
