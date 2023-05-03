package com.example.course.service.mongo.payment.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IPaymenService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoPayment;
import com.example.course.model.mongo.MongoSchedule;

import java.util.List;

public interface IPaymentService {
    MongoPayment create(MongoPayment payment);
    MongoPayment get(String id);
    MongoPayment update(MongoPayment payment);
    void delete(String id);
    List<MongoPayment> getAll();
}
