package com.sven.springboot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

/**
 * Created by 123 on 2016/8/29.
 */
@ConfigurationProperties(prefix = "wisely",locations = "classpath:config/wisely.properties")
public class WiselySettings {
    @NotNull
    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
