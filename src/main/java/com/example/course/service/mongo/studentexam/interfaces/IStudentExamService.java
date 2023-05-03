package com.example.course.service.mongo.studentexam.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IStudentExamService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/27/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoStudentExam;
import com.example.course.model.mysql.MySQLStudentExam;

import java.util.List;

public interface IStudentExamService {
     MongoStudentExam create(MongoStudentExam exam);
     MongoStudentExam get(String id);
     MongoStudentExam update(MongoStudentExam exam);
     void delete(String id);
     List<MongoStudentExam> getAll();
}
