package com.example.course.service.mongo.subject.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname SubjectMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/17/2022
 * Copyright notice
 */


import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoSubject;
import com.example.course.repository.mongo.SubjectMongoRepository;
import com.example.course.service.mongo.subject.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class SubjectMongoServiceImpls implements ISubjectService {

    @Autowired
    SubjectMongoRepository repository;

    @Override
    public MongoSubject create(MongoSubject subject) {
        subject.setCreatedAt(LocalDateTime.now());
        return repository.save(subject);
    }

    @Override
    public MongoSubject get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MongoSubject update(MongoSubject subject) {
        subject.setUpdatedAt(LocalDateTime.now());
        return repository.save(subject);
    }

    @Override
    public void delete(String id) {
//        if(!repository.existsById(id)){
//            throw new ApiRequestException("Не знайдено з таким id - " + id);
//        }
        repository.deleteById(id);
    }

    @Override
    public List<MongoSubject> getAll() {
        return repository.findAll();
    }
}
