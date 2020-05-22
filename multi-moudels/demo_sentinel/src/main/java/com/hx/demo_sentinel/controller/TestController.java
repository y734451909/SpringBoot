package com.hx.demo_sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/hello3")
    @SentinelResource("hello3")
    public String hello() {
        return "hello_3 Sentinel";
    }
}
