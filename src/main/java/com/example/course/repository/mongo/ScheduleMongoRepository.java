package com.example.course.repository.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname ScheduleMongoRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleMongoRepository extends MongoRepository<MongoSchedule, String> {
    List<MongoSchedule> findAllByDayContainingIgnoreCase(String str);
}
