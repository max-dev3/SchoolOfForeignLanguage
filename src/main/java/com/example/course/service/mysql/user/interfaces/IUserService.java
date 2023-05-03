package com.example.course.service.mysql.user.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IUserService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/20/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLTeacher;
import com.example.course.model.mysql.MySQLUser;

import java.util.List;

public interface IUserService {
    MySQLUser create(MySQLUser user);
    MySQLUser get(Long id);
    MySQLUser update(MySQLUser user);
    void delete(Long id);
    List<MySQLUser> getAll();
}
