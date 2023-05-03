package com.example.course.repository.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname TeacherMongoRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/8/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoTeacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMongoRepository extends MongoRepository<MongoTeacher, String> {
    List<MongoTeacher> findAllByLastNameContainingIgnoreCase(String str);
}
