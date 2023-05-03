package com.example.course.repository.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname UserMySQLRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/20/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMySQLRepository extends JpaRepository<MySQLUser,Long> {
    MySQLUser findByEmail(String email);
}
