package com.example.course.repository.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname SubjectMySQLRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectMySQLRepository extends JpaRepository<MySQLSubject, Long> {
}
