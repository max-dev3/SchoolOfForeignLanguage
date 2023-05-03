package com.example.course.service.mongo.user.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IUserService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/20/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoTeacher;
import com.example.course.model.mongo.MongoUser;

import java.util.List;

public interface IUserService {
    MongoUser create(MongoUser user);
    MongoUser get(String id);
    MongoUser update(MongoUser user);
    void delete(String id);
    List<MongoUser> getAll();
}
