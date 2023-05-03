package com.example.course.repository.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentExamMongoRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/27/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoStudentExam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentExamMongoRepository extends MongoRepository<MongoStudentExam, String> {
}
