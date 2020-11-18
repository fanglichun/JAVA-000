package com.flc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @creator fanglc@anchnet.com
 * @createdTime 2020/11/18 16:51
 * @desc
 */
@Configuration
@EnableConfigurationProperties(Jdbc.class)
public class Config{
    @Bean
    @ConditionalOnMissingBean
    public Jdbc jdbc() {
        return new Jdbc();
    }

}
