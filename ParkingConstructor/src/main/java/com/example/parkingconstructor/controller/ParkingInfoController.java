package com.example.parkingconstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingconstructor.dto.ResponseDetailsDTO;
import com.example.parkingconstructor.entity.ParkingConfirmartionDTO;
import com.example.parkingconstructor.entity.ParkingReqDTO;
import com.example.parkingconstructor.exception.RecordNotFoundException;
import com.example.parkingconstructor.service.ParkingLotserviceImpl;

@RestController
public class ParkingInfoController {
	
	@Autowired
	ParkingLotserviceImpl parkingservice;
	
	@Autowired
	Environment env;
	
	@GetMapping("/lotinfo")
	public String lotinf() {
		String port=env.getProperty("local.server.port");
		return "Parking Lot Bulk Running on "+port;
	}
	
	
	@GetMapping("/reqParkingSlot")
	public ResponseEntity<ResponseDetailsDTO> getParkingSlot(ParkingReqDTO reqDetails) throws RecordNotFoundException{
		ResponseDetailsDTO response=parkingservice.processReqParkingDetails(reqDetails);
		return new ResponseEntity<ResponseDetailsDTO>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@GetMapping("/vacateParkingSlot")
	public ResponseEntity<ResponseDetailsDTO> vacateParkingSlot(ParkingReqDTO reqDetails) throws RecordNotFoundException{
		ResponseDetailsDTO response=parkingservice.processReqParkingDetails(reqDetails);
		return new ResponseEntity<ResponseDetailsDTO>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/checkAllocatedParking/{parkingId}")
	public ResponseEntity<ParkingConfirmartionDTO> checkAllocatedParking(@PathVariable(name="parkingId")long parkingId) throws RecordNotFoundException{
		ParkingConfirmartionDTO response=parkingservice.checkalocatedParking(parkingId);
		return new ResponseEntity<ParkingConfirmartionDTO>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	
}
