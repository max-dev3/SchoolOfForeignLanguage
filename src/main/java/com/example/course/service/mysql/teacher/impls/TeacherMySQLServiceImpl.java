package com.example.course.service.mysql.teacher.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname TeacherMySQLServiceImpl
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/8/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoTeacher;
import com.example.course.model.mysql.MySQLTeacher;
import com.example.course.repository.mysql.TeacherMySQLRepository;
import com.example.course.service.mysql.teacher.interfaces.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TeacherMySQLServiceImpl implements ITeacherService {

    @Autowired
    TeacherMySQLRepository repository;

    @Override
    public MySQLTeacher create(MySQLTeacher teacher) {
        teacher.setCreatedAt(LocalDateTime.now());
        return repository.save(teacher);
    }

    @Override
    public MySQLTeacher get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MySQLTeacher update(MySQLTeacher teacher) {
        teacher.setUpdatedAt(LocalDateTime.now());
        return repository.save(teacher);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MySQLTeacher> getAll() {
        return repository.findAll();
    }

    public List<MySQLTeacher> getAllBySurname(String str){
        return repository.findAllByLastNameContainingIgnoreCase(str);

    }
}
