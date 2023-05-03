package com.example.course.service.mysql.exam.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IExamService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoExam;
import com.example.course.model.mysql.MySQLExam;

import java.util.List;

public interface IExamService {

    MySQLExam create(MySQLExam exam);
    MySQLExam get(Long id);
    MySQLExam update(MySQLExam exam);
    void delete(Long id);
    List<MySQLExam> getAll();
}
