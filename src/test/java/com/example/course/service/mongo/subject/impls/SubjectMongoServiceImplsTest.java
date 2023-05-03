package com.example.course.service.mongo.subject.impls;

import com.example.course.exception.ApiRequestException;
import com.example.course.model.mongo.MongoSubject;
import com.example.course.repository.mongo.SubjectMongoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static javafx.beans.binding.Bindings.when;
import static org.junit.jupiter.api.Assertions.*;

/*
 * author Fushtei Maksym
 * project course
 * classname SubjectMongoServiceImplsTest
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 10/31/2022
 * Copyright notice
 */

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
class SubjectMongoServiceImplsTest {

    @Mock
    private SubjectMongoRepository repository;

    @InjectMocks
    private SubjectMongoServiceImpls serviceImpls;

    @Test
    void create() {
        MongoSubject subject = new MongoSubject();
        subject.setName("name");
        Mockito.when(repository.save(subject)).thenReturn(subject);

        MongoSubject createdSubject = serviceImpls.create(subject);

        assertEquals("name", createdSubject.getName());

    }

    @Test
    void get() throws Exception {
        MongoSubject subject = new MongoSubject();
        subject.setId("1");
        Mockito.when(repository.findById(subject.getId())).thenReturn(Optional.of(subject));

        serviceImpls.get("1");

        Mockito.verify(repository).findById("1");
    }

    @Test
    void update() {
        MongoSubject subject = new MongoSubject();
        subject.setName("name");
        Mockito.when(repository.save(subject)).thenReturn(subject);

        MongoSubject createdSubject = serviceImpls.update(subject);

        assertEquals("name", createdSubject.getName());
    }

    @Test
    void delete() {
        Mockito.doNothing().when(repository).deleteById("2");

        serviceImpls.delete("2");

        Mockito.verify(repository).deleteById("2");
    }

    @Test
    void getAll() {
        MongoSubject subject = new MongoSubject();
        subject.setName("name");
        List<MongoSubject> allSubjects = Arrays.asList(subject);
        Mockito.when(repository.findAll()).thenReturn(allSubjects);

        List<MongoSubject> createdSubject = serviceImpls.getAll();

        assertEquals(allSubjects, createdSubject);


    }
}