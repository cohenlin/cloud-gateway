package com.cohen.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.DispatcherHandler;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients
public class GatewayApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Bean
    public DispatcherHandler webHandler(ApplicationContext applicationContext) {
        DispatcherHandler dispatcherHandler = new DispatcherHandler(applicationContext);
        return dispatcherHandler;
    }

    @Bean
    public ServerCodecConfigurer serverCodecConfigurer(){
        ServerCodecConfigurer serverCodecConfigurer = new DefaultServerCodecConfigurer();
        return serverCodecConfigurer;
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(p -> p.path("/get")
                        .filters(f -> f.addRequestParameter("param", "cohen"))
                        .uri("http://localhost:8080/get"))
                .route(p -> p.path("/post")
                        .filters(f -> f.addRequestParameter("param", "cohen"))
                        .uri("http://localhost:8080/post"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}