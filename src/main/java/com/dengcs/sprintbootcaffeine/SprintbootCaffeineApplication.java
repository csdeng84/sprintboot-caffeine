package com.dengcs.sprintbootcaffeine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableCaching
@ComponentScan(basePackages = {"controller","service"})
public class SprintbootCaffeineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprintbootCaffeineApplication.class, args);
    }

}
