package com.example.course.repository.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname UserMongoRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/20/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<MongoUser, String> {
    MongoUser findByEmail(String email);
}
