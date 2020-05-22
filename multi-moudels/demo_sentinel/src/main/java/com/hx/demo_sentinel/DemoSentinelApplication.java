package com.hx.demo_sentinel;
import com.alibaba.csp.sentinel.init.InitExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoSentinelApplication {
    public static void main(String[] args) {
      //  SpringApplication.run(DemoSentinelApplication.class, args);
        ConfigurableApplicationContext context=SpringApplication.run(DemoSentinelApplication.class, args);
        // 连接到控制台，与sentinel控制台通信
        System.setProperty("project.name",
                context.getEnvironment().getProperty("spring.application.name","sentinel"));
        System.setProperty("csp.sentinel.dashboard.server",
                context.getEnvironment().getProperty("sentinel.dashboard.server","localhost:8080"));
        InitExecutor.doInit();
    }
}
