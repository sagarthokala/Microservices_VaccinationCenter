package com.sagar.ms.vaccinationCenterService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VaccinationCenter {
	
	@Id
	private int id;
	
	private String centerName;
	
	private String centerAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

	@Override
	public String toString() {
		return "VaccinationCenter [id=" + id + ", centerName=" + centerName + ", centerAddress=" + centerAddress + "]";
	}

	
	
	

}
