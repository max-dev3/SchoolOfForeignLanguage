package com.example.course.service.mysql.contract.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IContractService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoContract;
import com.example.course.model.mysql.MySQLContract;

import java.util.List;

public interface IContractService {
    MySQLContract create(MySQLContract contract);
    MySQLContract get(Long id);
    MySQLContract update(MySQLContract contract);
    void delete(Long id);
    List<MySQLContract> getAll();
}
