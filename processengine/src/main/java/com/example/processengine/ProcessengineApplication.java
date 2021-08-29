package com.example.processengine;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ProcessengineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessengineApplication.class, args);
    }

}
