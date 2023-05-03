package com.example.course.repository.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname SubjectMongoRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/17/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoSubject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectMongoRepository extends MongoRepository<MongoSubject, String> {
}
