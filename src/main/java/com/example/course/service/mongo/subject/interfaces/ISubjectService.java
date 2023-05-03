package com.example.course.service.mongo.subject.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname ISubjectService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/17/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoSubject;

import java.util.List;

public interface ISubjectService {
    MongoSubject create(MongoSubject subject);
    MongoSubject get(String id);
    MongoSubject update(MongoSubject subject);
    void delete(String id);
    List<MongoSubject> getAll();
}
