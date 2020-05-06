package com.example.parkingconstructor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lotdetail")
public class LotDetail {

	@Id
	private Long lotid;
	private Long wingno;
	private String bname;
	private String city;
	public Long getLotid() {
		return lotid;
	}
	public void setLotid(Long lotid) {
		this.lotid = lotid;
	}
	public Long getWingno() {
		return wingno;
	}
	public void setWingno(Long wingno) {
		this.wingno = wingno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

		
	
	
	
}
