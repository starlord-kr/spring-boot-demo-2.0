package com.slowstarter.mvc.controller;

import com.slowstarter.mvc.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/v1/hello")
public class HelloController1 {

    private static Logger LOG = LoggerFactory.getLogger(HelloController1.class);

    private HelloService helloService;

    public HelloController1(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void hello1() {
        LOG.info("-- HelloController1.hello1()");
    }

    @RequestMapping("/call")
    public void callByGet() {
        helloService.call();
    }

}
