package com.example.convocationregistrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConvocationRegistrationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConvocationRegistrationServiceApplication.class, args);
    }

}
