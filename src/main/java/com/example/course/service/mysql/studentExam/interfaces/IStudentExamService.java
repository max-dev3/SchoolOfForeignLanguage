package com.example.course.service.mysql.studentExam.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IStudentExamService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/24/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLExam;
import com.example.course.model.mysql.MySQLStudentExam;

import java.util.List;

public interface IStudentExamService {
    MySQLStudentExam create(MySQLStudentExam exam);
    MySQLStudentExam get(Long id);
    MySQLStudentExam update(MySQLStudentExam exam);
    void delete(Long id);
    List<MySQLStudentExam> getAll();
}
