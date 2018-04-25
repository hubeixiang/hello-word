package com.sven.springboot.scheduling;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 123 on 2016/8/26.
 */
@Service
public class TaskScheDuling {
    public void scheduling() {
        System.out.println("TaskScheDuling>>>>>>" + new Date() + "...start");
    }
}
