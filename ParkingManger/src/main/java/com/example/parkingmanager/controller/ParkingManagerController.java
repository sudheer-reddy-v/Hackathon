package com.example.parkingmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingmanager.configuration.ParkFeignClient;
import com.example.parkingmanager.dto.ParkingConfirmartionDTO;
import com.example.parkingmanager.dto.ParkingReqDTO;
import com.example.parkingmanager.dto.ResponseDetailsDTO;
import com.example.parkingmanager.exception.RecordNotFoundException;

@RestController
public class ParkingManagerController {
	
	@Autowired
	ParkFeignClient parkingservice;
	
	@Autowired
	Environment env;
	
	@GetMapping("/lotinfo")
	public String lotinf() {
		String port=env.getProperty("local.server.port");
		return "Parking Lot Bulk Running on "+port;
	}
	
	
	@GetMapping("/reqParkingSlot")
	public ResponseEntity<ResponseDetailsDTO> getParkingSlot(ParkingReqDTO reqDetails) throws RecordNotFoundException{
		ResponseDetailsDTO response=parkingservice.requestParking(reqDetails);
		return new ResponseEntity<ResponseDetailsDTO>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@GetMapping("/vacateParkingSlot")
	public ResponseEntity<ResponseDetailsDTO> vacateParkingSlot(ParkingReqDTO reqDetails) throws RecordNotFoundException{
		ResponseDetailsDTO response=parkingservice.requestVactaing(reqDetails);
		return new ResponseEntity<ResponseDetailsDTO>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/checkAllocatedParking/{parkingId}")
	public ResponseEntity<ParkingConfirmartionDTO> checkAllocatedParking(@PathVariable(name="parkingId")long parkingId) throws RecordNotFoundException{
		ParkingConfirmartionDTO response=parkingservice.checkAllocatedSlot(parkingId);
		return new ResponseEntity<ParkingConfirmartionDTO>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
}
