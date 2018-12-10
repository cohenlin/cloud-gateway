package com.cohen.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
        List<User> list = new ArrayList<>();
        list.add(new User("刘德华", 18, "西湖区湖底公园1号"));
        list.add(new User("吴彦祖", 19, "西湖区湖底公园2号"));
        list.add(new User("周润发", 20, "西湖区湖底公园3号"));
        return ServerResponse.createBySuccess(list);
    }
}
