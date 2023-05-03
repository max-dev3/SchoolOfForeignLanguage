package com.example.course.service.mongo.contract.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IContractService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoContract;
import com.example.course.model.mongo.MongoExam;

import java.util.List;

public interface IContractService {
    MongoContract create(MongoContract contract);
    MongoContract get(String id);
    MongoContract update(MongoContract contract);
    void delete(String id);
    List<MongoContract> getAll();
}
