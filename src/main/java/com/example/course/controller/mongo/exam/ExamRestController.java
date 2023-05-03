package com.example.course.controller.mongo.exam;
/*
 * author Fushtei Maksym
 * project course
 * classname ContractRestController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/10/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoExam;
import com.example.course.service.mongo.exam.impls.ExamMongoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exams")
public class ExamRestController {
    @Autowired
    ExamMongoServiceImpl mongoService;

    @ApiOperation(value = "Show all", notes = "Show all exams")
    @GetMapping("/")
    List<MongoExam> showAll(){
        return mongoService.getAll();
    }

    @ApiOperation(value = "Show one", notes = "Show one exam")
    @GetMapping("/{id}")
    MongoExam showOne(@PathVariable String id){
        return mongoService.get(id);
    }

    @ApiOperation(value = "Delete one", notes = "Delete one exam")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id){
        mongoService.delete(id);
    }

    @ApiOperation(value = "Create one", notes = "Create one exam")
    @PostMapping("")
    MongoExam createOne(@RequestBody MongoExam exam){
        return mongoService.create(exam);
    }

    @ApiOperation(value = "Update one", notes = "Update one exam")
    @PutMapping("")
    MongoExam updateOne(@RequestBody MongoExam exam){
        return mongoService.update(exam);
    }


}
