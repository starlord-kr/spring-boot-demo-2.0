package com.slowstarter.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HiService {

    private static Logger LOG = LoggerFactory.getLogger(HiService.class);

    public void call() {
        LOG.info("-- HiService.call()");
    }
}
