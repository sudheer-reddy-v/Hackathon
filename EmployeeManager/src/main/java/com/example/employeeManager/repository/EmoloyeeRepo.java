package com.example.employeeManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeeManager.entity.EmployeeDetail;

public interface EmoloyeeRepo extends JpaRepository<EmployeeDetail, Long> {

}
