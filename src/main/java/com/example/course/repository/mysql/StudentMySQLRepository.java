package com.example.course.repository.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentMySQRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/7/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoStudent;
import com.example.course.model.mysql.MySQLStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMySQLRepository extends JpaRepository<MySQLStudent, Long> {
    List<MySQLStudent> findByFirstNameContainingIgnoreCase(String firstName );

}
