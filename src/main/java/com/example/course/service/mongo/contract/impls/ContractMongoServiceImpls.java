package com.example.course.service.mongo.contract.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname ContractMongoServiceImpls
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/19/2022
 * Copyright notice
 */

import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoContract;
import com.example.course.repository.mongo.ContractMongoRepository;
import com.example.course.service.mongo.contract.interfaces.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContractMongoServiceImpls implements IContractService {

     @Autowired
     ContractMongoRepository repository;

     @Override
     public MongoContract create(MongoContract contract) {
          contract.setCreatedAt(LocalDateTime.now());
          contract.setUpdatedAt(LocalDateTime.now());
          return repository.save(contract);
     }

     @Override
     public MongoContract get(String id) {

          return repository.findById(id).orElseThrow( () -> new ApiRequestException("Не знайдено з таким id - " + id));

     }

     @Override
     public MongoContract update(MongoContract contract) {
          contract.setUpdatedAt(LocalDateTime.now());
          return repository.save(contract);
     }

     @Override
     public void delete(String id) {
          if(!repository.existsById(id)){
               throw new ApiRequestException("Не знайдено з таким id - " + id);
          }
          repository.deleteById(id);
     }

     @Override
     public List<MongoContract> getAll() {
          return repository.findAll();
     }
}
