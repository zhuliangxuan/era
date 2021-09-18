package com.example.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class SampleController {

    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int age;

    @GetMapping("/user")
    public String user() {
        return "hello! "+userName+",age = "+age;
    }
}
