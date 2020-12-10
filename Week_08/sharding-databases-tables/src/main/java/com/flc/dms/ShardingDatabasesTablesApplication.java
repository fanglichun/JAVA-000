package com.flc.dms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 16:06
 * @desc
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.flc.dms.mapper")
public class ShardingDatabasesTablesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingDatabasesTablesApplication.class, args);
    }

}
