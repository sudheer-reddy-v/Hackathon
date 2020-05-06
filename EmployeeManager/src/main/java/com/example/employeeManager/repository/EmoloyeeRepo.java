package com.example.employeeManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeeManager.entity.EmployeeDetail;

@Repository
public interface EmoloyeeRepo extends JpaRepository<EmployeeDetail, Long> {

}
