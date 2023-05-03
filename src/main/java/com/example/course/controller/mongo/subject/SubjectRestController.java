package com.example.course.controller.mongo.subject;
/*
 * author Fushtei Maksym
 * project course
 * classname SubjectRestController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/10/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoGroup;
import com.example.course.model.mongo.MongoSubject;
import com.example.course.service.mongo.group.impls.GroupMongoServiceImpl;
import com.example.course.service.mongo.subject.impls.SubjectMongoServiceImpls;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectRestController {
    @Autowired
    SubjectMongoServiceImpls mongoService;

    @ApiOperation(value = "Get all", notes = "Show all subjects")
    @GetMapping("/")
    List<MongoSubject> showAll(){
        return mongoService.getAll();
    }

    @ApiOperation(value = "Get one", notes = "Show one subject")
    @GetMapping("/{id}")
    MongoSubject showOne(@PathVariable String id){
        return mongoService.get(id);
    }

    @ApiOperation(value = "Delete one", notes = "Delete one subject")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id){
        mongoService.delete(id);
    }

    @ApiOperation(value = "Create one", notes = "Create one subject")
    @PostMapping("")
    MongoSubject createOne(@RequestBody MongoSubject subject){
        return mongoService.create(subject);
    }

    @ApiOperation(value = "Update one", notes = "Update one subject")
    @PutMapping("")
    MongoSubject updateOne(@RequestBody MongoSubject subject){
        return mongoService.update(subject);
    }

}
