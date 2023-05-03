package com.example.course.service.mysql.language.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname ILanguageService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/10/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoLanguage;
import com.example.course.model.mysql.MySQLLanguage;

import java.util.List;

public interface ILanguageService {
    MySQLLanguage create(MySQLLanguage language);
    MySQLLanguage get(Long id);
    MySQLLanguage update(MySQLLanguage language);
    void delete(Long id);
    List<MySQLLanguage> getAll();
}
