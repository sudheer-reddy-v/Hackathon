package com.example.parkingconstructor.service;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.parkingconstructor.dto.ResponseDetailsDTO;
import com.example.parkingconstructor.entity.ParkingConfirmartionDTO;
import com.example.parkingconstructor.entity.ParkingReqDTO;
import com.example.parkingconstructor.exception.RecordNotFoundException;

public interface ParkingLotservice {


	ResponseDetailsDTO processReqParkingDetails(ParkingReqDTO details) throws RecordNotFoundException;
	ParkingConfirmartionDTO checkalocatedParking(long parkingId) throws RecordNotFoundException;
	default Long caluclateDays(String date1,String date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate d1 = LocalDate.parse(date1, dtf);
		LocalDate d2= LocalDate.parse(date, dtf);
		long daysBetween = Duration.between(d1, d2).toDays();
		System.out.println ("Days: " + daysBetween);
		return daysBetween;
		
	}
}
