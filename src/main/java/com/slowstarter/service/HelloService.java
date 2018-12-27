package com.slowstarter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private static Logger LOG = LoggerFactory.getLogger(HelloService.class);

    public void call() {
        LOG.info("-- HelloService.call()");
    }
}
