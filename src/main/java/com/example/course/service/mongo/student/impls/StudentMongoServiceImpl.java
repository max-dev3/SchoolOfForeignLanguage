package com.example.course.service.mongo.student.impls;
/*
 * author Fushtei Maksym
 * project course
 * classname StudentServiceImpl
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 8/1/2022
 * Copyright notice
 */


import com.example.course.dto.CountOutput;
import com.example.course.dto.JoinOutput;
import com.example.course.dto.SumOutput;
import com.example.course.exception.ApiException;
import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoStudent;
import com.example.course.repository.mongo.StudentMongoRepository;
import com.example.course.service.mongo.student.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentMongoServiceImpl implements IStudentService {

    @Autowired(required = false)
    MongoTemplate mongoTemplate;

    @Autowired
    StudentMongoRepository mongoRepository;


    @Override
    public MongoStudent create(MongoStudent student) {
        student.setCreatedAt(LocalDateTime.now());
        return mongoRepository.save(student);
    }

    @Override
    public MongoStudent get(String id) {
        return mongoRepository.findById(id).orElseThrow( () -> new ApiRequestException("Не знайдено з таким id - " + id));
    }

    @Override
    public MongoStudent update(MongoStudent student) {
        student.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(student);
    }

    @Override
    public void delete(String id) {

        if(!mongoRepository.existsById(id)){
            throw new ApiRequestException("Не знайдено з таким id - " + id);
        }
        mongoRepository.deleteById(id);
    }

    @Override
    public List<MongoStudent> getAll() {
        return mongoRepository.findAll();
    }

    public List<MongoStudent> getAllByStr(String name){
        return mongoRepository.findByFirstNameContainingIgnoreCase(name);
    }

    public List<MongoStudent> getAllOrderedByLastNameDesc(){

        return mongoRepository.findAllByOrderByLastNameDesc();
    }
    public List<MongoStudent> getAllOrderedByLastNameAsc(){

        return mongoRepository.findAllByOrderByLastNameAsc();
    }

    public List<MongoStudent> getAllByCreatedAtBetween(LocalDateTime from, LocalDateTime to){
        return mongoRepository.findAllByCreatedAtBetween(from, to);
    }

    public List<MongoStudent> getStudentByPageListed(int size, int page){
        return mongoRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public List<CountOutput> count(){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("age").count().as("total"),
                Aggregation.project("total").and("age").previousOperation(),
                Aggregation.sort(Sort.Direction.DESC, "total"));
        AggregationResults<CountOutput> countOutputs = mongoTemplate.aggregate(aggregation, MongoStudent.class, CountOutput.class);
        return countOutputs.getMappedResults();


    }

    public List<SumOutput> sum(){
        GroupOperation groupOperation = Aggregation.group("firstName").sum("age").as("agePerName");
        Aggregation aggregation = Aggregation.newAggregation(groupOperation);
        AggregationResults<SumOutput> sumOutputs = mongoTemplate.aggregate(aggregation, MongoStudent.class, SumOutput.class);
        return sumOutputs.getMappedResults();
    }

    public List<SumOutput> avg(){
        GroupOperation groupOperation = Aggregation.group("firstName").avg("age").as("agePerName");
        Aggregation aggregation = Aggregation.newAggregation(groupOperation);
        AggregationResults<SumOutput> sumOutputs = mongoTemplate.aggregate(aggregation, MongoStudent.class, SumOutput.class);
        return sumOutputs.getMappedResults();
    }

    public List<JoinOutput> join(){
        LookupOperation lookupOperation = Aggregation.lookup("mongoContract", "_id", "student._id", "contracts");
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
        AggregationResults<JoinOutput> sumOutputs = mongoTemplate.aggregate(aggregation, MongoStudent.class, JoinOutput.class);
        return sumOutputs.getMappedResults();
    }
}
