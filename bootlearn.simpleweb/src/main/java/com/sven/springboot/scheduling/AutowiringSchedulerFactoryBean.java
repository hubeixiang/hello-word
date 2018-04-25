package com.sven.springboot.scheduling;

import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Map;

/**
 * Created by 123 on 2016/8/26.
 */
public final class AutowiringSchedulerFactoryBean extends SchedulerFactoryBean {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        final Map<String, Trigger> triggers = this.applicationContext.getBeansOfType(Trigger.class);
        super.setTriggers(triggers.values().toArray(new Trigger[triggers.size()]));

        logger.debug("Autowired the following triggers defined in application context: {}", triggers.keySet().toString());
        super.afterPropertiesSet();
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) {
        super.setApplicationContext(applicationContext);
        this.applicationContext = applicationContext;
    }
}
