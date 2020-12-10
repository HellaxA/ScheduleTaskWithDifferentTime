package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

@Component
public class SchedulingWithBean {
    private ThreadPoolTaskScheduler taskScheduler;
    private ApplicationContext applicationContext;
    private Map<Integer, ScheduledFuture<?>> testCaseScheduleMap;

    @Autowired
    public SchedulingWithBean(ThreadPoolTaskScheduler taskScheduler, ApplicationContext applicationContext) {
        this.taskScheduler = taskScheduler;
        this.applicationContext = applicationContext;

        testCaseScheduleMap = new HashMap<>();
    }

    public void schedule() {
        //get testcases from db
        TestCase[] testCases = new TestCase[]{
                new TestCase(1, 3000L, "10 * * * * *"),
                new TestCase(2, 5000L, "15 * * * * *"),
                new TestCase(3, 10000L, "20 * * * * *")
        };

        for (TestCase testCase : testCases) {
            Task task = applicationContext.getBean(Task.class, testCase);

            ScheduledFuture<?> schedule = taskScheduler.schedule(
                    task,
                    new CronTrigger(testCase.getCron())
                    // new Date(System.currentTimeMillis() + testCase.getTime())
            );
            testCaseScheduleMap.put(testCase.getId(), schedule);
        }
    }
}
