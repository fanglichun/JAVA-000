package com.flc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/18 16:49
 * @desc
 */
@Data
@ConfigurationProperties(prefix = "jdbc")
public class Jdbc {
    private String driverClassName;
    private String url;
    private String userName;
    private String passWord;
}
