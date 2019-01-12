package com.slowstarter.mvc.controller;

import com.slowstarter.mvc.service.HiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/v1/hi")
public class HiController1 {

    private static Logger LOG = LoggerFactory.getLogger(HiController1.class);

    private HiService helloService;

    public HiController1(HiService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void hello1() {
        LOG.info("-- HiController1.hello1()");
    }

    @RequestMapping("/call")
    public void callByGet() {
        helloService.call();
    }

}
