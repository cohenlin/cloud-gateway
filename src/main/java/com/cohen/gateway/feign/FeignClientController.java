package com.cohen.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("wechat-app-server")
public interface FeignClientController {
    @GetMapping("/hello")
    String hello();
}