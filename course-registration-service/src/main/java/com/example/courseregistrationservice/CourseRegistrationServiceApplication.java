package com.example.courseregistrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CourseRegistrationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseRegistrationServiceApplication.class, args);
    }

}
