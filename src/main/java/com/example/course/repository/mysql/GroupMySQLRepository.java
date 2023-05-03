package com.example.course.repository.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname GroupMySQLRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mysql.MySQLGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface GroupMySQLRepository extends JpaRepository<MySQLGroup, Long> {
    MySQLGroup findByName(String name);

    @Query(value = "SELECT * FROM mysqlgroup where mysqllanguage_id = :languageId", nativeQuery = true)
    List<MySQLGroup> findMySQLGroupByLanguageId(Long languageId);

    @Query(value = "SELECT * FROM mysqlgroup where mysqlteacher_id = :teacherId", nativeQuery = true)
    List<MySQLGroup> findMySQLGroupByTeacherId(Long teacherId);

    @Query(value = "SELECT mysqlteacher_id, COUNT(distinct mysqllanguage_id) FROM coursework.mysqlgroup GROUP BY coursework.mysqlgroup.mysqlteacher_id;", nativeQuery = true)
    List<String> findTeachers();

    @Query(value = "select id from coursework.mysqlgroup where mysqllanguage_id = 3", nativeQuery = true)
    List<Long> findGermany();

    @Query(value = "SELECT * FROM coursework.mysqlgroup where amount_of_students <= 5", nativeQuery = true)
    List<MySQLGroup> findByAmountOfStudentsLessThanFive();

    @Query(value = "SELECT * FROM coursework.mysqlgroup where amount_of_students = 20", nativeQuery = true)
    List<MySQLGroup> findByAmountOfStudentsEqualsTwenty();

}
