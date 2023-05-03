package com.example.course.service.mysql.subject.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname SubjectMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/17/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLSubject;
import com.example.course.repository.mysql.SubjectMySQLRepository;
import com.example.course.service.mysql.subject.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class SubjectMySQLServiceImpl implements ISubjectService {

    @Autowired
    SubjectMySQLRepository repository;

    @Override
    public MySQLSubject create(MySQLSubject subject) {
        subject.setCreatedAt(LocalDateTime.now());
        return repository.save(subject);
    }

    @Override
    public MySQLSubject get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MySQLSubject update(MySQLSubject subject) {
        subject.setUpdatedAt(LocalDateTime.now());
        return repository.save(subject);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MySQLSubject> getAll() {
        return repository.findAll();
    }
}
