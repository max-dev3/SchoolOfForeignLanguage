package com.example.course.repository.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentMongoRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/5/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoStudent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentMongoRepository extends MongoRepository<MongoStudent, String> {

    List<MongoStudent> findByFirstNameContainingIgnoreCase(String firstName );
    List<MongoStudent> findAllByOrderByLastNameDesc();
    List<MongoStudent> findAllByOrderByLastNameAsc();
    List<MongoStudent> findAllByCreatedAtBetween(LocalDateTime from, LocalDateTime to);
}
