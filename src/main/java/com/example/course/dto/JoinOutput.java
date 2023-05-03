package com.example.course.dto;
/*
 * author Fushtei Maksym
 * project course
 * classname JoinOutput
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 10/24/2022
 * Copyright notice
 */


import com.example.course.model.mongo.MongoContract;

import java.util.List;

public class JoinOutput {
    String id;
    List<MongoContract> contracts;

    public JoinOutput(String id, List<MongoContract> contracts) {
        this.id = id;
        this.contracts = contracts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MongoContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<MongoContract> contracts) {
        this.contracts = contracts;
    }


}
