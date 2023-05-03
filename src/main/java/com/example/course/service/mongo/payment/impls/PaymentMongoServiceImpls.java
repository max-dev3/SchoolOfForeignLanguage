package com.example.course.service.mongo.payment.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname PaymentMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */


import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoPayment;
import com.example.course.repository.mongo.PaymentMongoRepository;
import com.example.course.service.mongo.payment.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PaymentMongoServiceImpls implements IPaymentService {

     @Autowired
     PaymentMongoRepository repository;

     @Override
     public MongoPayment create(MongoPayment payment) {
          payment.setCreatedAt(LocalDateTime.now());
          return repository.save(payment);
     }

     @Override
     public MongoPayment get(String id) {

          return repository.findById(id).orElseThrow( () -> new ApiRequestException("Не знайдено з таким id - " + id));
     }

     @Override
     public MongoPayment update(MongoPayment payment) {
          payment.setUpdatedAt(LocalDateTime.now());
          return repository.save(payment);
     }

     @Override
     public void delete(String id) {
          if(!repository.existsById(id)){
               throw new ApiRequestException("Не знайдено з таким id - " + id);
          }
          repository.deleteById(id);
     }

     @Override
     public List<MongoPayment> getAll() {
          return repository.findAll();
     }
}
