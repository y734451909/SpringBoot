package com.hx.demo_sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    /**
     * 限流降级
     * @return
     */
    @SentinelResource(value = "sayHello", blockHandler = "sayHelloExceptionHandler")
    public String sayHello(String name){
        return "hello,"+ name;
    }

    /**
     * 熔断降级
     * @return
     */
    @SentinelResource(value = "circuitBreaker", fallback = "circuitBreakerFallback", blockHandler = "sayHelloExceptionHandler")
    public String circuitBreaker(String name){
        if ("zhangsan".equals(name)){
            return "hello,"+ name;
        }
        throw new RuntimeException("发生异常");
    }

    public String circuitBreakerFallback(String name){
        return "服务异常，熔断降级, 请稍后重试!";
    }

    public String sayHelloExceptionHandler(String name, BlockException ex){
        return "访问过快，限流降级, 请稍后重试!";
    }
}
