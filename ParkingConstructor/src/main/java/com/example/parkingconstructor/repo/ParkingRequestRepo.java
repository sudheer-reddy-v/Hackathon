package com.example.parkingconstructor.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.parkingconstructor.entity.ParkingReqDTO;

public interface ParkingRequestRepo extends JpaRepository<ParkingReqDTO, Long> {
	
	@Query("select lot from ParkingReqDTO lot where status='Y'")
	public List<ParkingReqDTO> findAvailedVactePaking();

}
