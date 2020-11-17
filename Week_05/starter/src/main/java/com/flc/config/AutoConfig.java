package com.flc.config;

import com.flc.bean.Klass;
import com.flc.bean.Student;
import com.flc.service.School;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/17 11:22
 * @desc
 */
@Configuration
@EnableConfigurationProperties(Student.class)
public class AutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public Klass klass() {
        return new Klass();
    }

    @Bean
    @ConditionalOnMissingBean
    public School school() {
        return new School();
    }
}
