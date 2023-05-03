package com.example.course.service.mongo.schedule.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname ScheduleMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */


import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoSchedule;
import com.example.course.repository.mongo.ScheduleMongoRepository;
import com.example.course.service.mongo.schedule.interfaces.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ScheduleMongoServiceImpls implements IScheduleService {

     @Autowired
     ScheduleMongoRepository repository;

     @Override
     public MongoSchedule create(MongoSchedule schedule) {
          schedule.setCreatedAt(LocalDateTime.now());
          return repository.save(schedule);
     }

     @Override
     public MongoSchedule get(String id) {
          return repository.findById(id).orElseThrow( () -> new ApiRequestException("Не знайдено з таким id - " + id));
     }

     @Override
     public MongoSchedule update(MongoSchedule schedule) {
          schedule.setCreatedAt(LocalDateTime.now());
          return repository.save(schedule);
     }

     @Override
     public void delete(String id) {
          if(!repository.existsById(id)){
               throw new ApiRequestException("Не знайдено з таким id - " + id);
          }
          repository.deleteById(id);
     }

     @Override
     public List<MongoSchedule> getAll() {
          return repository.findAll();
     }

     public List<MongoSchedule> getAllByDay(String str){
          return repository.findAllByDayContainingIgnoreCase(str);
     }
}
