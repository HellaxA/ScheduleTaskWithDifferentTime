package com.example.demo;

import org.springframework.stereotype.Component;

public class TestCase {
    private int id;
    private long time;
    private String cron;

    public TestCase() {
    }

    public TestCase(int id, long time) {
        this.id = id;
        this.time = time;
    }

    public TestCase(int id, long time, String cron) {
        this.id = id;
        this.time = time;
        this.cron = cron;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
