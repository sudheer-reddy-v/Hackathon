package com.example.parkingconstructor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingconstructor.entity.FreeParkingSpace;

@Repository
public interface FreeSpaceRepo extends JpaRepository<FreeParkingSpace, Long>{

}
