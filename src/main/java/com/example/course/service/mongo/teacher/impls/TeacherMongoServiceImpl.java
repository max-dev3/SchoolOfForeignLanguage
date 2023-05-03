package com.example.course.service.mongo.teacher.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname TeacherMongoService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/8/2022
 * Copyright notice
 */


import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoTeacher;
import com.example.course.repository.mongo.TeacherMongoRepository;
import com.example.course.service.mongo.teacher.interfaces.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TeacherMongoServiceImpl implements ITeacherService {

     @Autowired
     TeacherMongoRepository repository;

     @Override
     public MongoTeacher create(MongoTeacher teacher) {
          teacher.setCreatedAt(LocalDateTime.now());
          return repository.save(teacher);
     }

     @Override
     public MongoTeacher get(String id) {
          return repository.findById(id).orElseThrow( () -> new ApiRequestException("Не знайдено з таким id - " + id));

     }

     @Override
     public MongoTeacher update(MongoTeacher teacher) {
          teacher.setUpdatedAt(LocalDateTime.now());
          return repository.save(teacher);
     }

     @Override
     public void delete(String id) {
          if(!repository.existsById(id)){
               throw new ApiRequestException("Не знайдено з таким id - " + id);
          }
          repository.deleteById(id);
     }

     @Override
     public List<MongoTeacher> getAll() {
          return repository.findAll();
     }

     public List<MongoTeacher> getAllBySurname(String str){
               return repository.findAllByLastNameContainingIgnoreCase(str);

     }
}
