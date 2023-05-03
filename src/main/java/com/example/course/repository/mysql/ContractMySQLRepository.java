package com.example.course.repository.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname ContractMySQLRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */

import com.example.course.model.mysql.MySQLContract;
import com.example.course.model.mysql.MySQLStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractMySQLRepository extends JpaRepository<MySQLContract, Long> {

    @Query(value = "SELECT  * FROM coursework.mysqlcontract GROUP BY coursework.mysqlcontract.mysqlstudent_id having COUNT(distinct mysqlgroup_id) > 3;", nativeQuery = true)
    List<MySQLContract> findStudents();

    @Query(value = "SELECT * FROM coursework.mysqlcontract where mysqlstudent_id = :studentId", nativeQuery = true)
    List<MySQLContract> findByStudentId(Long studentId);

    @Query(value = "SELECT * FROM coursework.mysqlcontract where mysqlgroup_id in :list", nativeQuery = true)
    List<MySQLContract> findByGroup(List<Long> list);

    @Query(value = "SELECT  * FROM coursework.mysqlcontract GROUP BY coursework.mysqlcontract.mysqlstudent_id having COUNT(distinct mysqlgroup_id) > 1;", nativeQuery = true)
    List<MySQLContract> findStudentsMoreOneLanguage();
}
