package com.example.course.service.mysql.student.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IStudentService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/7/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLStudent;

import java.util.List;

public interface IStudentService {
    MySQLStudent create(MySQLStudent student);
    MySQLStudent get(Long id);
    MySQLStudent update(MySQLStudent student);
    void delete(Long id);
    List<MySQLStudent> getAll();
}
