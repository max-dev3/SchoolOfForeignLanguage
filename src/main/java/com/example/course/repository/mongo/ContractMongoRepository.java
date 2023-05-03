package com.example.course.repository.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname ContractMongoRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoContract;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractMongoRepository extends MongoRepository<MongoContract, String> {

}
