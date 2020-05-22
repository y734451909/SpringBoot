package com.hx.demo_sentinel.controller;

import com.hx.demo_sentinel.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello1")
    public String hello(@RequestParam("name") String name){
        return helloService.sayHello(name);
    }

    @GetMapping("/hello2")
    public String circuitBreaker(@RequestParam("name") String name){
        return helloService.circuitBreaker(name);
    }
}