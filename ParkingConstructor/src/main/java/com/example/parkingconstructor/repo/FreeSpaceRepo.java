package com.example.parkingconstructor.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.parkingconstructor.entity.FreeParkingSpace;

@Repository
public interface FreeSpaceRepo extends JpaRepository<FreeParkingSpace, Long>{
	
	@Query("SELECT u FROM FreeParkingSpace u WHERE e.date BETWEEN :date AND date2 AND lotId=lotId ")
	public List<FreeParkingSpace> findAvalibleSlots(@Param("date1") Date date1,@Param("date2") Date date2);

}
