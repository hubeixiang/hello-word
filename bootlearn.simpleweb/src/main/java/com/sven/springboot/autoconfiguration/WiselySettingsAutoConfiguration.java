package com.sven.springboot.autoconfiguration;

import com.sven.springboot.configuration.WiselySettings;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 123 on 2016/8/29.
 */
@EnableConfigurationProperties(WiselySettings.class)
@Configuration
public class WiselySettingsAutoConfiguration {
}
