package com.example.course.controller.mongo.contract;
/*
 * author Fushtei Maksym
 * project course
 * classname ContractRestController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/10/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoContract;
import com.example.course.service.mongo.contract.impls.ContractMongoServiceImpls;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contracts")
public class ContractRestController {
    @Autowired
    ContractMongoServiceImpls mongoService;

    @ApiOperation(value = "Show all", notes = "Show all contracts")
    @GetMapping("/")
    List<MongoContract> showAll(){
        return mongoService.getAll();
    }

    @ApiOperation(value = "Show one", notes = "Show one contract")
    @GetMapping("/{id}")
    MongoContract showOne(@PathVariable String id){
        return mongoService.get(id);
    }

    @ApiOperation(value = "Delete one", notes = "Delete one contract")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id){
        mongoService.delete(id);
    }

    @ApiOperation(value = "Create one", notes = "Create one contract")
    @PostMapping("")
    MongoContract createOne(@RequestBody MongoContract contract){
        return mongoService.create(contract);
    }

    @ApiOperation(value = "Update one", notes = "Update one contract")
    @PutMapping("")
    MongoContract updateOne(@RequestBody MongoContract contract){
        return mongoService.update(contract);
    }

}
