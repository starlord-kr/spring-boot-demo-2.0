package com.slowstarter.mvc.controller;

import com.slowstarter.mvc.exception.InvalidParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
public class HiController2 {

    @GetMapping("/v2/hi/{bool}")
    public Boolean returnTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }

    @PostMapping("/v2/hi/{bool}")
    public Boolean postTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }

    @PutMapping("/v2/hi/{bool}")
    public Boolean putTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }

    @DeleteMapping("/v2/hi/{bool}")
    public Boolean deleteTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }
}
