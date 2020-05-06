package com.example.parkingmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.parkingmanager.configuration.RibbonConfiguration;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RibbonClient(name="PARKING_LOT-INFO", configuration = RibbonConfiguration.class)
public class ParkingMangerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingMangerApplication.class, args);
	}

}
