package com.example.course.repository.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname ExamMySQLRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/22/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamMySQLRepository extends JpaRepository<MySQLExam, Long> {
}
