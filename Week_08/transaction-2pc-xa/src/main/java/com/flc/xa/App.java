package com.flc.xa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/10 17:19
 * @desc
 */
@SpringBootApplication(scanBasePackages = "com.flc.xa")
@Import(TransactionConfiguration.class)
public class App {
    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }
}
