package com.example.course.service.mongo.language.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname LanguageMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/10/2022
 * Copyright notice
 */

import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoLanguage;
import com.example.course.repository.mongo.LanguageMongoRepository;
import com.example.course.service.mongo.language.interfaces.ILanguageService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LanguageMongoServiceImpls implements ILanguageService {

    @Autowired
    LanguageMongoRepository repository;

    @Override
    public MongoLanguage create(MongoLanguage language) {
        language.setCreatedAt(LocalDateTime.now());
        return repository.save(language);
    }

    @Override
    public MongoLanguage get(String id) {
        return repository.findById(id).orElseThrow( () -> new ApiRequestException("Не знайдено з таким id - " + id));
    }

    @Override
    public MongoLanguage update(MongoLanguage language) {
        language.setUpdatedAt(LocalDateTime.now());
        return repository.save(language);
    }

    @Override
    public void delete(String id) {
        if(!repository.existsById(id)){
            throw new ApiRequestException("Не знайдено з таким id - " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<MongoLanguage> getAll() {
        return repository.findAll();
    }


}
