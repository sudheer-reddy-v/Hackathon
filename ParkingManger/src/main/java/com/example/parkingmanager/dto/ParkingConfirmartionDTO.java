package com.example.parkingmanager.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ALLOCATED_DETAILS")
public class ParkingConfirmartionDTO {
	
	@Id
	@GeneratedValue
	private long id;
	private String parkingId;
	private String eId;
	private Date fromDate;
	private Date toDate;
	private long lotid;
	
	public ParkingConfirmartionDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getParkingId() {
		return parkingId;
	}

	public void setParkingId(String parkingId) {
		this.parkingId = parkingId;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public long getLotid() {
		return lotid;
	}

	public void setLotid(long lotid) {
		this.lotid = lotid;
	}
	
	
	
}
