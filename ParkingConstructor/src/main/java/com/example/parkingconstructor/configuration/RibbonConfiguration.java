package com.example.parkingconstructor.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

@Configuration
public class RibbonConfiguration {

	@Autowired
	IClientConfig config;
	
	@Bean
	public IPing ribbonping(IClientConfig config) {
		return new PingUrl();
	}
	
	@Bean
	public IRule ribbonrule(IClientConfig config) {
		return new AvailabilityFilteringRule();
	}
	
	
	
}
