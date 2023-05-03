package com.example.course.service.mongo.group.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IGroupService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/9/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoGroup;

import java.util.List;

public interface IGroupService {
    MongoGroup create(MongoGroup group);
    MongoGroup get(String id);
    MongoGroup update(MongoGroup group);
    void delete(String id);
    List<MongoGroup> getAll();
    MongoGroup getByName(String name);
}
