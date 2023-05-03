package com.example.course.service.mysql.contract.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname ContractMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoContract;
import com.example.course.model.mysql.MySQLContract;
import com.example.course.repository.mongo.ContractMongoRepository;
import com.example.course.repository.mysql.ContractMySQLRepository;
import com.example.course.service.mysql.contract.interfaces.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContractMySQLServiceImpls implements IContractService {

     @Autowired
     ContractMySQLRepository repository;

     @Override
     public MySQLContract create(MySQLContract contract) {
          contract.setCreatedAt(LocalDateTime.now());
          return repository.save(contract);
     }

     @Override
     public MySQLContract get(Long id) {
          return repository.findById(id).orElse(null);
     }

     @Override
     public MySQLContract update(MySQLContract contract) {
          contract.setUpdatedAt(LocalDateTime.now());
          return repository.save(contract);
     }

     @Override
     public void delete(Long id) {
          repository.deleteById(id);
     }

     @Override
     public List<MySQLContract> getAll() {
          return repository.findAll();
     }

     public List<MySQLContract> getContractsByStudent(){
          return repository.findStudents();
     }

     public List<MySQLContract> getByStudentId(Long id){
          return repository.findByStudentId(id);
     }

     public List<MySQLContract> getByGroupId(List<Long> list){
          return repository.findByGroup(list);
     }

     public List<MySQLContract> getContractsByStudentMoreOneLanguage(){
          return repository.findStudentsMoreOneLanguage();
     }
}
