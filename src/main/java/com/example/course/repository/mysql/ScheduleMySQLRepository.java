package com.example.course.repository.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname ScheduleMySQLRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */

import com.example.course.model.mongo.Day;
import com.example.course.model.mongo.MongoSchedule;
import com.example.course.model.mysql.MySQLContract;
import com.example.course.model.mysql.MySQLGroup;
import com.example.course.model.mysql.MySQLSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface ScheduleMySQLRepository extends JpaRepository<MySQLSchedule, Long> {
    @Query(value = "SELECT * FROM coursework.mysqlschedule where mysqlgroup_id = :groupId", nativeQuery = true)
    List<MySQLSchedule> findMySQLScheduleByGroup(Long groupId);

    @Query(value = "SELECT * FROM coursework.mysqlschedule where mysqlteacher_id = :teacherId", nativeQuery = true)
    List<MySQLSchedule> findMySQLScheduleByTeacher(Long teacherId);


}
