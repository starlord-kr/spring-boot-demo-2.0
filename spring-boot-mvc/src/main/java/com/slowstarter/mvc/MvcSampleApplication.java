package com.slowstarter.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.slowstarter.mvc")
public class MvcSampleApplication {

    static Logger LOG = LoggerFactory.getLogger(MvcSampleApplication.class);

    public static void main(String[] args) {
        LOG.info("-- MvcSampleApplication Running!!!");
        SpringApplication.run(MvcSampleApplication.class, args);
    }
}
