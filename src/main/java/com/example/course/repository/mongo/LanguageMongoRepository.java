package com.example.course.repository.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname LanguageMongoRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/10/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoLanguage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageMongoRepository extends MongoRepository<MongoLanguage, String> {
}
