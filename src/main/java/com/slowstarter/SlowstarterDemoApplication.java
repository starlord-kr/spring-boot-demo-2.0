package com.slowstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SlowstarterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlowstarterDemoApplication.class, args);
    }

    @GetMapping
    public String HelloWorld() {
        return "Hello World";
    }
}
