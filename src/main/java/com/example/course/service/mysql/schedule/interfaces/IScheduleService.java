package com.example.course.service.mysql.schedule.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IScheduleService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoSchedule;
import com.example.course.model.mysql.MySQLSchedule;

import java.util.List;

public interface IScheduleService {
    MySQLSchedule create(MySQLSchedule schedule);
    MySQLSchedule get(Long id);
    MySQLSchedule update(MySQLSchedule schedule);
    void delete(Long id);
    List<MySQLSchedule> getAll();
}
