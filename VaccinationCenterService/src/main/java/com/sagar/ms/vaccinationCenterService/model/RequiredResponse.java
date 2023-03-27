package com.sagar.ms.vaccinationCenterService.model;

import java.util.List;

import com.sagar.ms.vaccinationCenterService.entities.VaccinationCenter;


public class RequiredResponse {

	private VaccinationCenter center;
	private List<Citizen> citizens;
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	@Override
	public String toString() {
		return "RequiredResponse [center=" + center + ", citizens=" + citizens + "]";
	}
	
	
}
