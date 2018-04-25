package com.sven.springboot.autoconfiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Created by 123 on 2016/8/27.
 */
@Configuration
public class UtilsAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(SpringContextUtil.class)
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SpringContextUtil contextUtil() {
        return new SpringContextUtil();
    }
}
