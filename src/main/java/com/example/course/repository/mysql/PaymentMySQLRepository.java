package com.example.course.repository.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname PaymentMySQLRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */

import com.example.course.model.mysql.MySQLGroup;
import com.example.course.model.mysql.MySQLPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMySQLRepository extends JpaRepository<MySQLPayment, Long> {


    @Query(value = "SELECT * FROM coursework.mysqlpayment where total_amount-paid_amount=0;", nativeQuery = true)
    List<MySQLPayment> findFullPayment();

    @Query(value = "SELECT * FROM coursework.mysqlpayment where total_amount-paid_amount= total_amount;", nativeQuery = true)
    List<MySQLPayment> findNullPayment();

    @Query(value = "SELECT * FROM coursework.mysqlpayment where total_amount-paid_amount < total_amount / 2 and total_amount != paid_amount;", nativeQuery = true)
    List<MySQLPayment> findPartPayment();

    @Query(value = "SELECT * FROM coursework.mysqlpayment where postpone_payment = 1;", nativeQuery = true)
    List<MySQLPayment> findPostPonePayment();

    @Query(value = "SELECT * FROM coursework.mysqlpayment where privilege = 1;", nativeQuery = true)
    List<MySQLPayment> findPrivilegePayment();

    MySQLPayment findByContractId(Long id);


}
