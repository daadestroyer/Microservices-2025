package com.thecoderstv.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    @LoadBalanced // It will tell and enable a feature where RestTemplate call another
                // microservice based on service name and not on port and localhost
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
