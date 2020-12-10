package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitBean implements InitializingBean {
    private SchedulingWithBean schedulingWithBean;

    @Autowired
    public InitBean(SchedulingWithBean schedulingWithBean) {
        this.schedulingWithBean = schedulingWithBean;
    }

    @Override
    public void afterPropertiesSet() {
        schedulingWithBean.schedule();
    }
}
