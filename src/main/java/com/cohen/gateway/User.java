package com.cohen.gateway;

import java.util.UUID;

/**
 * @Author: linjincheng
 * @createTime: Created in 2018/12/10 14:09
 * @version: v1.0.0
 * @copyright: choice
 * @email: ljc@choicesoft.com.cn
 */
public class User {
    private String id;
    private String name;
    private Integer age;
    private String address;

    public User(String name, Integer age, String address) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
