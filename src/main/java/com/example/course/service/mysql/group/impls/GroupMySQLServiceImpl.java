package com.example.course.service.mysql.group.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname IGroupService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/9/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mysql.MySQLGroup;
import com.example.course.repository.mongo.GroupMongoRepository;
import com.example.course.repository.mysql.GroupMySQLRepository;
import com.example.course.service.mysql.group.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class GroupMySQLServiceImpl implements IGroupService {

    @Autowired
    GroupMySQLRepository repository;

    @Override
    public MySQLGroup create(MySQLGroup group) {
        group.setCreatedAt(LocalDateTime.now());
        return repository.save(group);
    }

    @Override
    public MySQLGroup get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MySQLGroup update(MySQLGroup group) {
        group.setUpdatedAt(LocalDateTime.now());
        return repository.save(group);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MySQLGroup> getAll() {
        return repository.findAll();
    }

    @Override
    public MySQLGroup getByName(String name){
        return repository.findByName(name);
    }

    public List<MySQLGroup> getByLanguage(Long languageId){
        return repository.findMySQLGroupByLanguageId(languageId);
    }

    public List<MySQLGroup> getByTeacher(Long teacherId){
        return repository.findMySQLGroupByTeacherId(teacherId);
    }

    public List<String> getTeacherAndLanguage(){
        return repository.findTeachers();
    }

    public List<Long> getByGermany(){
        return repository.findGermany();
    }

    public List<MySQLGroup> getByAmountOfStudentsLessThanFive(){
        return repository.findByAmountOfStudentsLessThanFive();
    }
    public List<MySQLGroup> getByAmountOfStudentsEqualsTwenty(){
        return repository.findByAmountOfStudentsEqualsTwenty();
    }


}
