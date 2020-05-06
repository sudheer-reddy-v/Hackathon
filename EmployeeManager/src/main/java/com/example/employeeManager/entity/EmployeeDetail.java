package com.example.employeeManager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDetail {
	@Id
	private long eId;
	private String ename;
	private String email;
	private long phoneNumber;
	private String designation;
	private long experience;
	private long lotid;
	private String status;
	
	public EmployeeDetail() {
		
	}

	public long geteId() {
		return eId;
	}

	public void seteId(long eId) {
		this.eId = eId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getExperience() {
		return experience;
	}

	public void setExperience(long experience) {
		this.experience = experience;
	}

	public long getLotid() {
		return lotid;
	}

	public void setLotid(long lotid) {
		this.lotid = lotid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
