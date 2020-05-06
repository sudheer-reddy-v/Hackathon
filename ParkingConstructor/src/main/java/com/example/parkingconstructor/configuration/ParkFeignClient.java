package com.example.parkingconstructor.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="EMPLOYEE-INFO")
public interface ParkFeignClient {
	
	
	@RequestMapping(method=RequestMethod.GET, value="/getLotID/{empId}")
	public long getLotId(@PathVariable("empId")Long  empId) ;
	

}
