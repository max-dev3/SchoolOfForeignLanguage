package com.example.course.service.mongo.exam.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IExamService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoExam;
import com.example.course.model.mongo.MongoGroup;

import java.util.List;

public interface IExamService {

    MongoExam create(MongoExam exam);
    MongoExam get(String id);
    MongoExam update(MongoExam exam);
    void delete(String id);
    List<MongoExam> getAll();
}
