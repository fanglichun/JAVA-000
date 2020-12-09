package com.flc.xa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 16:06
 * @desc
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.flc.xa.mapper")
public class ShardingSphereXAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereXAApplication.class, args);
    }

}
