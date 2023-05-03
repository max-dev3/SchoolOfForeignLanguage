package com.example.course.repository.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname GroupMongoRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/9/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoGroup;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMongoRepository extends MongoRepository<MongoGroup, String> {
    MongoGroup findByName(String name);

    @Aggregation(pipeline = {" { '$match': { 'language.name':  ?0}}"})
    List<MongoGroup> findByLanguage(String lang);
}
