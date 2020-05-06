package com.example.parkingconstructor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.parkingconstructor.entity.ParkingConfirmartionDTO;

@Repository
public interface AllocatedParkingRepo extends JpaRepository<ParkingConfirmartionDTO, Long> {
	

	@Query("select lot from AllocatedParkingRepo lot where parkingId=:parkingId")
	ParkingConfirmartionDTO getAllocatedParkingByID(long parkingId);
	

}
