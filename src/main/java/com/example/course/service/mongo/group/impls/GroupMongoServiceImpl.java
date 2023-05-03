package com.example.course.service.mongo.group.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname IGroupService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/9/2022
 * Copyright notice
 */


import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoGroup;
import com.example.course.repository.mongo.GroupMongoRepository;
import com.example.course.service.mongo.group.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GroupMongoServiceImpl implements IGroupService {

    @Autowired
    GroupMongoRepository repository;

    @Override
    public MongoGroup create(MongoGroup group) {
        group.setCreatedAt(LocalDateTime.now());
        return repository.save(group);
    }

    @Override
    public MongoGroup get(String id) {
        return repository.findById(id).orElseThrow( () -> new ApiRequestException("Не знайдено з таким id - " + id));
    }

    @Override
    public MongoGroup update(MongoGroup group) {
        group.setUpdatedAt(LocalDateTime.now());
        return repository.save(group);
    }

    @Override
    public void delete(String id) {
        if(!repository.existsById(id)){
            throw new ApiRequestException("Не знайдено з таким id - " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<MongoGroup> getAll() {
        return repository.findAll();
    }

    @Override
    public MongoGroup getByName(String name){
        return repository.findByName(name);
    }

    public List<MongoGroup> getByLanguage(String language){
        return repository.findByLanguage(language);
    }
}
