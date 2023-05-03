package com.example.course.service.mongo.student.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IStudentService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/1/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoStudent;

import java.util.List;

public interface IStudentService {
    MongoStudent create(MongoStudent student);
    MongoStudent get(String id);
    MongoStudent update(MongoStudent student);
    void delete(String id);
    List<MongoStudent> getAll();
}

