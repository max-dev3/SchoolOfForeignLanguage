package com.example.course.service.mongo.user.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname UserMongoServiceImpl
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/20/2022
 * Copyright notice
 */


import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoUser;
import com.example.course.repository.mongo.UserMongoRepository;
import com.example.course.service.mongo.user.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMongoServiceImpl implements IUserService {

     @Autowired
     UserMongoRepository repository;

     @Override
     public MongoUser create(MongoUser user) {
          return repository.save(user);
     }

     @Override
     public MongoUser get(String id) {
          return repository.findById(id).orElseThrow( () -> new ApiRequestException("Не знайдено з таким id - " + id));
     }

     @Override
     public MongoUser update(MongoUser user) {
          return repository.save(user);
     }

     @Override
     public void delete(String id) {
          if(!repository.existsById(id)){
               throw new ApiRequestException("Не знайдено з таким id - " + id);
          }
          repository.deleteById(id);
     }

     @Override
     public List<MongoUser> getAll() {
          return repository.findAll();
     }

     public MongoUser getByEmail(String email){
          return repository.findByEmail(email);
     }
}
