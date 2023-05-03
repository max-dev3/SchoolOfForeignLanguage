package com.example.course.service.mongo.language.interfaces;
/*
 * author Fushtei Maksym
 * project course
 * classname ILanguageService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/10/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoLanguage;

import java.util.List;

public interface ILanguageService {
    MongoLanguage create(MongoLanguage language);
    MongoLanguage get(String id);
    MongoLanguage update(MongoLanguage language);
    void delete(String id);
    List<MongoLanguage> getAll();
}
