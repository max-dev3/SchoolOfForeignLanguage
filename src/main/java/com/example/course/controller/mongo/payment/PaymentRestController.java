package com.example.course.controller.mongo.payment;
/*
 * author Fushtei Maksym
 * project course
 * classname PaymentRestController
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 9/10/2022
 * Copyright notice
 */

import com.example.course.model.mongo.MongoPayment;
import com.example.course.service.mongo.payment.impls.PaymentMongoServiceImpls;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentRestController {
    @Autowired
    PaymentMongoServiceImpls mongoService;

    @ApiOperation(value = "Show all", notes = "Show all payments")
    @GetMapping("/")
    List<MongoPayment> showAll(){
        return mongoService.getAll();
    }

    @ApiOperation(value = "Show one", notes = "Show one payment")
    @GetMapping("/{id}")
    MongoPayment showOne(@PathVariable String id){
        return mongoService.get(id);
    }

    @ApiOperation(value = "Delete one", notes = "Delete one payment")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id){
        mongoService.delete(id);
    }

    @ApiOperation(value = "Create one", notes = "Create one payment")
    @PostMapping("")
    MongoPayment createOne(@RequestBody MongoPayment payment){
        return mongoService.create(payment);
    }

    @ApiOperation(value = "Update one", notes = "Update one payment")
    @PutMapping("")
    MongoPayment updateOne(@RequestBody MongoPayment payment){
        return mongoService.update(payment);
    }

}
