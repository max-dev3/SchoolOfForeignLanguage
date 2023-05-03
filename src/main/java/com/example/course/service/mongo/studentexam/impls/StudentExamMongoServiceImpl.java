package com.example.course.service.mongo.studentexam.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentExamMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/27/2022
 * Copyright notice
 */


import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoStudentExam;
import com.example.course.repository.mongo.StudentExamMongoRepository;
import com.example.course.service.mongo.studentexam.interfaces.IStudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class StudentExamMongoServiceImpl implements IStudentExamService {

     @Autowired
     StudentExamMongoRepository repository;

     @Override
     public MongoStudentExam create(MongoStudentExam exam) {
          exam.setCreatedAt(LocalDateTime.now());
          return repository.save(exam);
     }

     @Override
     public MongoStudentExam get(String id) {
          return repository.findById(id).orElseThrow( () -> new ApiRequestException("Не знайдено з таким id - " + id));
     }

     @Override
     public MongoStudentExam update(MongoStudentExam exam) {
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
     public List<MongoStudentExam> getAll() {
          return repository.findAll();
     }
}
