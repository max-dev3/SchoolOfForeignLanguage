package com.example.course.service.mysql.schedule.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname ScheduleMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */


import com.example.course.model.mongo.Day;
import com.example.course.model.mongo.MongoSchedule;
import com.example.course.model.mysql.MySQLSchedule;
import com.example.course.repository.mysql.ScheduleMySQLRepository;
import com.example.course.service.mysql.schedule.interfaces.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ScheduleMySQLServiceImpl implements IScheduleService {

     @Autowired
     ScheduleMySQLRepository repository;

     @Override
     public MySQLSchedule create(MySQLSchedule schedule) {
          schedule.setCreatedAt(LocalDateTime.now());
          return repository.save(schedule);
     }

     @Override
     public MySQLSchedule get(Long id) {
          return repository.findById(id).orElse(null);
     }

     @Override
     public MySQLSchedule update(MySQLSchedule schedule) {
          schedule.setCreatedAt(LocalDateTime.now());
          return repository.save(schedule);
     }

     @Override
     public void delete(Long id) {
          repository.deleteById(id);
     }

     @Override
     public List<MySQLSchedule> getAll() {
          return repository.findAll();
     }

     public List<MySQLSchedule> getByGroup(Long id){
          return repository.findMySQLScheduleByGroup(id);
     }
     public List<MySQLSchedule> getByTeacher(Long id){
          return repository.findMySQLScheduleByTeacher(id);
     }

     public List<MySQLSchedule> getAllByDay(String str){
          return this.getAll().stream()
                  .filter(day -> day.getDay().toString().toLowerCase(Locale.ROOT).contains(str.toLowerCase(Locale.ROOT)))
                  .collect(Collectors.toList());

     }

}
