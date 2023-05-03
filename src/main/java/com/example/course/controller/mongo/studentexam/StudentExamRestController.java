package com.example.course.controller.mongo.studentexam;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentExamRestController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/10/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoStudentExam;
import com.example.course.service.mongo.student.impls.StudentMongoServiceImpl;
import com.example.course.service.mongo.studentexam.impls.StudentExamMongoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student-exams")
public class StudentExamRestController {
    @Autowired
    StudentExamMongoServiceImpl mongoService;

    @ApiOperation(value = "Get all", notes = "Show all marks")
    @GetMapping("/")
    List<MongoStudentExam> showAll(){
        return mongoService.getAll();
    }

    @ApiOperation(value = "Get one", notes = "Show one student's mark")
    @GetMapping("/{id}")
    MongoStudentExam showOne(@PathVariable String id){
        return mongoService.get(id);
    }

    @ApiOperation(value = "Delete one", notes = "Delete one student's mark")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id){
        mongoService.delete(id);
    }

    @ApiOperation(value = "Create one", notes = "Create one student's mark")
    @PostMapping("")
    MongoStudentExam createOne(@RequestBody MongoStudentExam exam){
        return mongoService.create(exam);
    }

    @ApiOperation(value = "Update one", notes = "Update one student's mark")
    @PutMapping("")
    MongoStudentExam updateOne(@RequestBody MongoStudentExam exam){
        return mongoService.update(exam);
    }

}
