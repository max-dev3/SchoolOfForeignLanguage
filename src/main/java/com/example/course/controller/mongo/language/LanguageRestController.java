package com.example.course.controller.mongo.language;
/*
 * author Fushtei Maksym
 * project course
 * classname LanguageRestController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/10/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoLanguage;
import com.example.course.service.mongo.language.impls.LanguageMongoServiceImpls;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguageRestController {

     @Autowired
     LanguageMongoServiceImpls mongoService;

     @ApiOperation(value = "Show all", notes = "Show all languages")
     @GetMapping("/")
     List<MongoLanguage> showAll(){
          return mongoService.getAll();
     }

     @ApiOperation(value = "Show one", notes = "Show one language")
     @GetMapping("/{id}")
     MongoLanguage showOne(@PathVariable String id){
          return mongoService.get(id);
     }

     @ApiOperation(value = "Delete one", notes = "Delete one language")
     @DeleteMapping("/{id}")
     void deleteOne(@PathVariable String id){
          mongoService.delete(id);
     }

     @ApiOperation(value = "Create one", notes = "Create one language")
     @PostMapping("")
     MongoLanguage createOne(@RequestBody MongoLanguage language){
          return mongoService.create(language);
     }

     @ApiOperation(value = "Update one", notes = "Update one language")
     @PutMapping("")
     MongoLanguage updateOne(@RequestBody MongoLanguage language){
          return mongoService.update(language);
     }



}
