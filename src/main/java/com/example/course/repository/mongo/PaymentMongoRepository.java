package com.example.course.repository.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname PaymentMongoRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoPayment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMongoRepository extends MongoRepository<MongoPayment, String> {
}
