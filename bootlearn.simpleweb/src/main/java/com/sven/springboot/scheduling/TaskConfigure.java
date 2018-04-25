package com.sven.springboot.scheduling;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

/**
 * Created by 123 on 2016/8/26.
 */
@Configuration
public class TaskConfigure {
    @Bean
    public MethodInvokingJobDetailFactoryBean jobDetailEomsNoticeTaskSchedule(
            TaskScheDuling taskService) {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetObject(taskService);
        bean.setTargetMethod("scheduling");
        bean.setName("EomsNoticeTaskSchedule");
        return bean;
    }

    @Bean
    public CronTriggerFactoryBean triggerJobDetailEomsNoticeTaskSchedule(
            @Qualifier("jobDetailEomsNoticeTaskSchedule") JobDetail jobDetailEomsNoticeTaskSchedule) {
        final int second = (int) (Math.random() * 60);

        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(jobDetailEomsNoticeTaskSchedule);
        bean.setStartDelay(40000); // 20s
        //每15分钟轮询发送一次工单通知
//		bean.setCronExpression(String.format("%d */15 * * * ?", second));
        bean.setCronExpression(String.format("%d * * * * ?", second));
        bean.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);
        return bean;
    }
}
