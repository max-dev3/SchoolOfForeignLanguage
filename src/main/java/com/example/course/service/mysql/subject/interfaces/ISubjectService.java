package com.example.course.service.mysql.subject.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname ISubjectService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/17/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoSubject;
import com.example.course.model.mysql.MySQLSubject;

import java.util.List;

public interface ISubjectService {
    MySQLSubject create(MySQLSubject subject);
    MySQLSubject get(Long id);
    MySQLSubject update(MySQLSubject subject);
    void delete(Long id);
    List<MySQLSubject> getAll();
}
