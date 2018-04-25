package com.sven.springboot.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * Created by 123 on 2016/8/25.
 * 一种是这样配置，另外一种是添加Factory,在Application中添加
 */
@EnableScheduling
@Configuration
public class ScheDulingConfig {

    @Scheduled(cron = "0/20 * * * * ?") //每20秒执行一次
    public void scheduling() {
        System.out.println("ScheDulingConfig>>>>>>" + new Date() + "...start");
    }
}
