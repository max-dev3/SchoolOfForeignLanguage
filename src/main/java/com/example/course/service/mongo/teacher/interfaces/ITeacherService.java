package com.example.course.service.mongo.teacher.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname ITeacherService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/8/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoTeacher;

import java.util.List;

public interface ITeacherService {
    MongoTeacher create(MongoTeacher teacher);
    MongoTeacher get(String id);
    MongoTeacher update(MongoTeacher teacher);
    void delete(String id);
    List<MongoTeacher> getAll();
}
