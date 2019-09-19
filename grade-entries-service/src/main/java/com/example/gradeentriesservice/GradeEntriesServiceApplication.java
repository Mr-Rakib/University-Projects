package com.example.gradeentriesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GradeEntriesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradeEntriesServiceApplication.class, args);
    }

}
