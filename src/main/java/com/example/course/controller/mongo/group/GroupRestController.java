package com.example.course.controller.mongo.group;
/*
 * author Fushtei Maksym
 * project course
 * classname groupRestController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/10/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoGroup;
import com.example.course.service.mongo.group.impls.GroupMongoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupRestController {

    @Autowired
    GroupMongoServiceImpl mongoService;

    @ApiOperation(value = "Show all", notes = "Show all groups")
    @GetMapping("/")
    List<MongoGroup> showAll(){
        return mongoService.getAll();
    }

    @ApiOperation(value = "Show one", notes = "Show one group")
    @GetMapping("/{id}")
    MongoGroup showOne(@PathVariable String id){
        return mongoService.get(id);
    }

    @ApiOperation(value = "Delete one", notes = "Delete one group")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id){
        mongoService.delete(id);
    }

    @ApiOperation(value = "Create one", notes = "Create one group")
    @PostMapping("")
    MongoGroup createOne(@RequestBody MongoGroup group){
        return mongoService.create(group);
    }

    @ApiOperation(value = "Update one", notes = "Update one group")
    @PutMapping("")
    MongoGroup updateOne(@RequestBody MongoGroup group){
        return mongoService.update(group);
    }


}
