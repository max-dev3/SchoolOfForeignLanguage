package com.example.course.service.mysql.payment.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname PaymentMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLPayment;
import com.example.course.repository.mysql.PaymentMySQLRepository;
import com.example.course.service.mysql.payment.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PaymentMySQLServiceImpl implements IPaymentService {

     @Autowired
     PaymentMySQLRepository repository;

     @Override
     public MySQLPayment create(MySQLPayment payment) {
          payment.setCreatedAt(LocalDateTime.now());
          return repository.save(payment);
     }

     @Override
     public MySQLPayment get(Long id) {
          return repository.findById(id).orElse(null);
     }

     @Override
     public MySQLPayment update(MySQLPayment payment) {
          payment.setUpdatedAt(LocalDateTime.now());
          return repository.save(payment);
     }

     @Override
     public void delete(Long id) {
          repository.deleteById(id);
     }

     @Override
     public List<MySQLPayment> getAll() {
          return repository.findAll();
     }

     public List<MySQLPayment> getFullPayment(){
          return repository.findFullPayment();
     }

     public List<MySQLPayment> getEmpty(){
          return repository.findNullPayment();
     }

     public List<MySQLPayment> getPartPayment(){
          return repository.findPartPayment();
     }

     public List<MySQLPayment> getPostponePayment(){
          return repository.findPostPonePayment();
     }

     public List<MySQLPayment> getPrivilegePayment(){
          return repository.findPrivilegePayment();
     }

     public MySQLPayment getPaymentsByContractId(Long id){
          return repository.findByContractId(id);
     }


}
