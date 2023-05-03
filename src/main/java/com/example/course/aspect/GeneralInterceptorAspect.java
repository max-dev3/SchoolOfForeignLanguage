package com.example.course.aspect;
/*
 * author Fushtei Maksym
 * project course
 * classname GeneralInterceptorAspect
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 10/17/2022
 * Copyright notice
 */

import com.example.course.service.mongo.student.impls.StudentMongoServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class GeneralInterceptorAspect {

     Logger logger = LogManager.getLogger(StudentMongoServiceImpl.class);

     @Pointcut("this(com.example.course.service.mongo.student.impls.StudentMongoServiceImpl)")
     public void loggingPointCut(){}

     @Before("loggingPointCut()")
     public void before(JoinPoint joinPoint){
          logger.info("Before method invoked:: " + joinPoint.getSignature());
     }

     @After("loggingPointCut()")
     public void after(JoinPoint joinPoint){
          logger.info("After method invoked:: " + joinPoint.getSignature());
     }

     @Around("loggingPointCut()")
     public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
          long start = System.nanoTime();
          Object retrieval = proceedingJoinPoint.proceed();
          long end = System.nanoTime();
          String methodName = proceedingJoinPoint.getSignature().getName();
          logger.info("Execution of " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start));
          return retrieval;
     }
}
