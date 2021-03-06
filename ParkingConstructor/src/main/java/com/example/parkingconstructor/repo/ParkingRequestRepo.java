package com.example.parkingconstructor.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.parkingconstructor.entity.ParkingReqDTO;

@Repository
public interface ParkingRequestRepo extends JpaRepository<ParkingReqDTO, Long> {
	
	@Query("select lot from ParkingReqDTO lot where status='Y' AND reqType='Vacate'")
	public List<ParkingReqDTO> findAvailedVactePaking();

	@Query("select lot from ParkingReqDTO lot where status='Y' AND reqType='Request'")
	public List<ParkingReqDTO> findAvailedRequestPaking();
}
