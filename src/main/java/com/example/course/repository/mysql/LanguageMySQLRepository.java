package com.example.course.repository.mysql;
/*
 * author Fushtei Maksym
 * project course
 * classname LanguageMySQLRepository
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/21/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageMySQLRepository extends JpaRepository<MySQLLanguage, Long> {
}
