package com.example.parkingmanager.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.parkingmanager.dto.ParkingConfirmartionDTO;
import com.example.parkingmanager.dto.ParkingReqDTO;
import com.example.parkingmanager.dto.ResponseDetailsDTO;
import com.example.parkingmanager.exception.RecordNotFoundException;


@FeignClient(name="PARKING-INFO")
public interface ParkFeignClient {
	
	
	@RequestMapping(method=RequestMethod.GET, value="/reqParkingSlot")
	public ResponseDetailsDTO requestParking(ParkingReqDTO details) throws RecordNotFoundException ;
	

	@RequestMapping(method=RequestMethod.GET, value="/vacateParkingSlot")
	public ResponseDetailsDTO requestVactaing(ParkingReqDTO details) throws RecordNotFoundException ;
	
	@RequestMapping(method=RequestMethod.GET, value="/checkAllocatedParking/{parkingId}")
	public ParkingConfirmartionDTO checkAllocatedSlot(@PathVariable("parkingId")Long  parkingId) throws RecordNotFoundException ;
	

}
