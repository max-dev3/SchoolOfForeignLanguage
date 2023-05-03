package com.example.course.service.mysql.language.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname LanguageMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/10/2022
 * Copyright notice
 */

import com.example.course.model.mysql.MySQLLanguage;
import com.example.course.repository.mysql.LanguageMySQLRepository;
import com.example.course.service.mysql.language.interfaces.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LanguageMySQLServiceImpl implements ILanguageService {

    @Autowired
    LanguageMySQLRepository repository;

    @Override
    public MySQLLanguage create(MySQLLanguage language) {
        language.setCreatedAt(LocalDateTime.now());
        return repository.save(language);
    }

    @Override
    public MySQLLanguage get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MySQLLanguage update(MySQLLanguage language) {
        language.setUpdatedAt(LocalDateTime.now());
        return repository.save(language);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MySQLLanguage> getAll() {
        return repository.findAll();
    }


}
