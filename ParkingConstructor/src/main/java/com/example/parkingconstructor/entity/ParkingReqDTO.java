package com.example.parkingconstructor.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Request_Parking_Manager")
public class ParkingReqDTO {
	
	@Id
	@GeneratedValue
	private long requestID;
	private long eid;
	private Date fromDate;
	private Date toDate;
	private String reqType;
	private String status;
	
	public ParkingReqDTO() {
		// TODO Auto-generated constructor stub
	}

	public long getRequestID() {
		return requestID;
	}

	public void setRequestID(long requestID) {
		this.requestID = requestID;
	}

	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
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

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
