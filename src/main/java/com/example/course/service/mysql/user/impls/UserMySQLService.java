package com.example.course.service.mysql.user.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname UserMySQLService
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/20/2022
 * Copyright notice
 */


import com.example.course.model.mysql.MySQLUser;
import com.example.course.repository.mysql.UserMySQLRepository;
import com.example.course.service.mysql.user.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserMySQLService implements IUserService {

   @Autowired
   UserMySQLRepository repository;


   @Override
   public MySQLUser create(MySQLUser user) {
      return repository.save(user);
   }

   @Override
   public MySQLUser get(Long id) {
      return repository.findById(id).orElse(null);
   }

   @Override
   public MySQLUser update(MySQLUser user) {
      return repository.save(user);
   }

   @Override
   public void delete(Long id) {
      repository.deleteById(id);
   }

   @Override
   public List<MySQLUser> getAll() {
      return repository.findAll();
   }

   public MySQLUser getByEmail(String email){
      return repository.findByEmail(email);
   }
}
