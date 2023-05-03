package com.example.course.controller.mongo.schedule;
/*
 * author Fushtei Maksym
 * project course
 * classname ScheduleRestController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/10/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoSchedule;
import com.example.course.model.mongo.MongoStudent;
import com.example.course.service.mongo.schedule.impls.ScheduleMongoServiceImpls;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
public class ScheduleRestController {

    @Autowired
    ScheduleMongoServiceImpls mongoService;

    @ApiOperation(value = "Show all", notes = "Show all schedules")
    @GetMapping("/")
    List<MongoSchedule> showAll(){
        return mongoService.getAll();
    }

    @ApiOperation(value = "Show one", notes = "Show one schedule")
    @GetMapping("/{id}")
    MongoSchedule showOne(@PathVariable String id){
        return mongoService.get(id);
    }

    @ApiOperation(value = "Delete one", notes = "Delete one schedule")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id){
        mongoService.delete(id);
    }

    @ApiOperation(value = "Create one", notes = "Create one schedule")
    @PostMapping("")
    MongoSchedule createOne(@RequestBody MongoSchedule schedule){
        return mongoService.create(schedule);
    }

    @ApiOperation(value = "Update one", notes = "Update one schedule")
    @PutMapping("")
    MongoSchedule updateOne(@RequestBody MongoSchedule schedule){
        return mongoService.update(schedule);
    }


}
