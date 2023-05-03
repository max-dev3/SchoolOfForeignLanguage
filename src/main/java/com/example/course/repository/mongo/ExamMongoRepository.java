package com.example.course.repository.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname ExamMongoRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/18/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoExam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamMongoRepository extends MongoRepository<MongoExam, String> {
}
