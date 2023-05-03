package com.example.course.service.mysql.payment.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname IPaymenService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoPayment;
import com.example.course.model.mysql.MySQLPayment;

import java.util.List;

public interface IPaymentService {
    MySQLPayment create(MySQLPayment payment);
    MySQLPayment get(Long id);
    MySQLPayment update(MySQLPayment payment);
    void delete(Long id);
    List<MySQLPayment> getAll();
}
