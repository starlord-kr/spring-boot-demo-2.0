package com.slowstarter.mvc.controller;

import com.slowstarter.mvc.exception.InvalidParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/hi/")
public class HiController3 {

    @GetMapping("{bool}")
    public Boolean returnTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }

    @PostMapping("{bool}")
    public Boolean postTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }

    @PutMapping("{bool}")
    public Boolean putTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }

    @DeleteMapping("{bool}")
    public Boolean deleteTrue(@PathVariable("bool") Boolean bool) {
        if(!Boolean.TRUE.equals(bool)) {
            throw new InvalidParameterException("{bool} must be TRUE!");
        }
        return bool;
    }
}
