package com.cohen.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DispatcherController {
    @Autowired
    private FeignClientController feignClientController;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return feignClientController.hello();
    }
}