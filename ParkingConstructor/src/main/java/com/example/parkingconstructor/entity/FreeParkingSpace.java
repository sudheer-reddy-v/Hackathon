package com.example.parkingconstructor.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FREE_SPACE_DAY")
public class FreeParkingSpace {
	
	@Id
	@GeneratedValue
	private long  id;
	private long reqId;
	private long empId;
	private long lotId;
	private Date date;
	
	public FreeParkingSpace() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getReqId() {
		return reqId;
	}

	public void setReqId(long reqId) {
		this.reqId = reqId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getLotId() {
		return lotId;
	}

	public void setLotId(long lotId) {
		this.lotId = lotId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
