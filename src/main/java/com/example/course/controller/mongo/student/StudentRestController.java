package com.example.course.controller.mongo.student;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentRestController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/1/2022
 * Copyright notice
 */

import com.example.course.dto.CountOutput;
import com.example.course.dto.JoinOutput;
import com.example.course.dto.SumOutput;
import com.example.course.model.mongo.MongoStudent;
import com.example.course.service.mongo.student.impls.StudentMongoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

    @Autowired
    StudentMongoServiceImpl mongoService;

    @ApiOperation(value = "Get all", notes = "Show all students")
    @GetMapping("/")
    List<MongoStudent> showAll(){
        return mongoService.getAll();
    }

    @ApiOperation(value = "Get one", notes = "Show one student")
    @GetMapping("/{id}")
    MongoStudent showOne(@PathVariable String id){
        return mongoService.get(id);
    }

    @ApiOperation(value = "Delete one", notes = "Delete one student")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id){
        mongoService.delete(id);
    }

    @ApiOperation(value = "Create one", notes = "Create one student")
    @PostMapping("")
    MongoStudent createOne(@RequestBody MongoStudent student){
        return mongoService.create(student);
    }

    @ApiOperation(value = "Update one", notes = "Update one student")
    @PutMapping("")
    MongoStudent updateOne(@RequestBody MongoStudent student){
        return mongoService.update(student);
    }

    @GetMapping("/search/name/{str}")
    List<MongoStudent> getAllByFirstName(@PathVariable() String str){
        return mongoService.getAllByStr(str);
    }

    @GetMapping("/order/lastName/desc")
    List<MongoStudent> getAllSortedByLastNameDesc(){
        return mongoService.getAllOrderedByLastNameDesc();
    }
    @GetMapping("/order/lastName/asc")
    List<MongoStudent> getAllSortedByLastNameAsc(){
        return mongoService.getAllOrderedByLastNameAsc();
    }

    @GetMapping("/range")
    List<MongoStudent> getAllInRange(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME )LocalDateTime first,
                                     @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime second){
        return mongoService.getAllByCreatedAtBetween(first, second);
    }

    @GetMapping("/paging/{size}&{page}")
    List<MongoStudent> getPageableAsList(@PathVariable Integer size, @PathVariable Integer page){
        return mongoService.getStudentByPageListed(size, page);
    }

    @GetMapping("/count")
    List<CountOutput> count(){
        return mongoService.count();
    }

    @GetMapping("/sum")
    List<SumOutput> sum(){
        return mongoService.sum();
    }

    @GetMapping("/avg")
    List<SumOutput> avg(){
        return mongoService.avg();
    }

    @GetMapping("/join")
    List<JoinOutput> join(){
        return mongoService.join();
    }
}



