package com.slowstarter.mvc.controller;

import com.slowstarter.mvc.exception.InvalidParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController2 {

    @GetMapping("/v2/hello/{bool}")
    public Boolean returnTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }

    @PostMapping("/v2/hello/{bool}")
    public Boolean postTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }

    @PutMapping("/v2/hello/{bool}")
    public Boolean putTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }

    @DeleteMapping("/v2/hello/{bool}")
    public Boolean deleteTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }
}
