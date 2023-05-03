package com.example.course.service.mysql.group.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IGroupService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/9/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mysql.MySQLGroup;

import java.util.List;

public interface IGroupService {
    MySQLGroup create(MySQLGroup group);
    MySQLGroup get(Long id);
    MySQLGroup update(MySQLGroup group);
    void delete(Long id);
    List<MySQLGroup> getAll();
    MySQLGroup getByName(String name);
}
