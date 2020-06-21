package com.example.taskmanagerzullproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableEurekaClient
public class TaskManagerZullProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerZullProxyApplication.class, args);
    }

}
