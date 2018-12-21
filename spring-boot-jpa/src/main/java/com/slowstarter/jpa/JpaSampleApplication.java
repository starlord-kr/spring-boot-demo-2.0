package com.slowstarter.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaSampleApplication {

    static Logger LOG = LoggerFactory.getLogger(JpaSampleApplication.class);

    public static void main(String[] args) {
        LOG.info("-- JpaSampleApplication Running!!!");
        SpringApplication.run(JpaSampleApplication.class, args);
    }
}
