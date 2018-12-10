package com.cohen.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/12/10 12:57
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return ServerResponse.createBySuccess("hello");
    }
}
