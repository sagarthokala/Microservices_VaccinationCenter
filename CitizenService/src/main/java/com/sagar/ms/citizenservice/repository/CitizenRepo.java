package com.sagar.ms.citizenservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagar.ms.citizenservice.entities.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
	
	public List<Citizen> findByVaccinationCenterId(Integer id);

}
