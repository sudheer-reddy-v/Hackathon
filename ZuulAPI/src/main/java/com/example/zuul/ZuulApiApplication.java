package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
public class ZuulApiApplication {

	@EnableEurekaClient
	@EnableZuulServer
	public static void main(String[] args) {
		SpringApplication.run(ZuulApiApplication.class, args);
	}

}
