package com.example.course.controller.mongo.teacher;
/*
 * author Fushtei Maksym
 * project course
 * classname TeacherRestController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/10/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoStudent;
import com.example.course.model.mongo.MongoTeacher;
import com.example.course.service.mongo.student.impls.StudentMongoServiceImpl;
import com.example.course.service.mongo.teacher.impls.TeacherMongoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teachers")
public class TeacherRestController {
    @Autowired
    TeacherMongoServiceImpl mongoService;

    @ApiOperation(value = "Get all", notes = "Show all teachers")
    @GetMapping("/")
    List<MongoTeacher> showAll(){
        return mongoService.getAll();
    }

    @ApiOperation(value = "Get one", notes = "Show one teacher")
    @GetMapping("/{id}")
    MongoTeacher showOne(@PathVariable String id){
        return mongoService.get(id);
    }

    @ApiOperation(value = "Delete one", notes = "Delete one teacher")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id){
        mongoService.delete(id);
    }

    @ApiOperation(value = "Create one", notes = "Create one teacher")
    @PostMapping("")
    MongoTeacher createOne(@RequestBody MongoTeacher teacher){
        return mongoService.create(teacher);
    }

    @ApiOperation(value = "Update one", notes = "Update one teacher")
    @PutMapping("")
    MongoTeacher updateOne(@RequestBody MongoTeacher teacher){
        return mongoService.update(teacher);
    }


}
