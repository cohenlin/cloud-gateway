package com.cohen.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DispatcherController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/{serverid}/{path}", method = RequestMethod.GET)
    public String hello(@PathVariable("serverid") String serverid, @PathVariable("path") String path) {
        String uri = "http://" + serverid.toUpperCase() + "/" + path;
        return restTemplate.getForEntity(uri, String.class).getBody();
    }
}