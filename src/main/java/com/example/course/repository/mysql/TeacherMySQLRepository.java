package com.example.course.repository.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname TeacherMySQLRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/8/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoTeacher;
import com.example.course.model.mysql.MySQLTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMySQLRepository extends JpaRepository<MySQLTeacher, Long> {
    List<MySQLTeacher> findAllByLastNameContainingIgnoreCase(String str);

}
