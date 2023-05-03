package com.example.course.service.mysql.teacher.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname ITeacherService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/8/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLTeacher;

import java.util.List;

public interface ITeacherService {
    MySQLTeacher create(MySQLTeacher teacher);
    MySQLTeacher get(Long id);
    MySQLTeacher update(MySQLTeacher teacher);
    void delete(Long id);
    List<MySQLTeacher> getAll();
}
