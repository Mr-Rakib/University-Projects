package com.example.humanresourcemanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HumanResourceManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanResourceManagementServiceApplication.class, args);
    }

}
