package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

public class Task implements Runnable{
    private TestCase testCase;
    private static final Logger logger = LoggerFactory.getLogger(Task.class);

    public Task(TestCase testCase) {
        this.testCase = testCase;
    }

    @Override
    public void run() {
        logger.info("TEST CASE WITH ID " +  testCase.getId() +  " IS RUNNING. Time: " + new Date());
    }

}
