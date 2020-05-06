package com.example.employeeManager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employeeManager.entity.EmployeeDetail;
import com.example.employeeManager.repository.EmoloyeeRepo;

@Controller
public class EmployeeController {
	
	@Autowired
	EmoloyeeRepo repo; 
	
	@GetMapping("/getLOTID/{parkingId}")
	public ResponseEntity<Long> checkAllocatedParking(@PathVariable(name="parkingId")long parkingId) {
		Optional<EmployeeDetail> response=repo.findById(parkingId);
		return new ResponseEntity<Long>(response.get().geteId(), new HttpHeaders(), HttpStatus.OK);
	}

}
