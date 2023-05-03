package com.example.course.service.mongo.schedule.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IScheduleService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoExam;
import com.example.course.model.mongo.MongoSchedule;

import java.util.List;

public interface IScheduleService {
    MongoSchedule create(MongoSchedule schedule);
    MongoSchedule get(String id);
    MongoSchedule update(MongoSchedule schedule);
    void delete(String id);
    List<MongoSchedule> getAll();
}
