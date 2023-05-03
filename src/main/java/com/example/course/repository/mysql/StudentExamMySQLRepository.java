package com.example.course.repository.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentExamMySQLRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/22/2022
 * Copyright notice
 */

import com.example.course.model.mysql.MySQLStudentExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentExamMySQLRepository extends JpaRepository<MySQLStudentExam, Long> {
    @Query(value = "SELECT * FROM mysqlstudent_exam where certificate = 0;", nativeQuery = true)
    List<MySQLStudentExam> getStudentByCertificate();

    @Query(value = "SELECT COUNT( * ) FROM coursework.mysqlstudent_exam WHERE certificate =0", nativeQuery = true)
    int getAmountOfStudent();

    @Query(value = "SELECT mysqlexam_id FROM coursework.mysqlstudent_exam WHERE certificate =0", nativeQuery = true)
    List<Long> getExamId();
}
