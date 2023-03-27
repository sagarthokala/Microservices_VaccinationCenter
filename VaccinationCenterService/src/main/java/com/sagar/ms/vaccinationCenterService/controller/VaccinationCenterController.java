package com.sagar.ms.vaccinationCenterService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sagar.ms.vaccinationCenterService.entities.VaccinationCenter;
import com.sagar.ms.vaccinationCenterService.model.Citizen;
import com.sagar.ms.vaccinationCenterService.model.RequiredResponse;
import com.sagar.ms.vaccinationCenterService.repo.VaccinationCenterRepo;

@RestController
@RequestMapping("/vacciantioncenter")
public class VaccinationCenterController {

	@Autowired
	VaccinationCenterRepo vaccinationCenterRepo;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter newcenter) {
		VaccinationCenter center = vaccinationCenterRepo.save(newcenter);
		return new ResponseEntity<>(center, HttpStatus.OK);
	}

//	@GetMapping("/id/{id}")
//	public ResponseEntity<RequiredResponse> getCitizensBasenOnCenter(@PathVariable Integer id){
//		RequiredResponse requiredResponse = new RequiredResponse();
//		
//		VaccinationCenter center = vaccinationCenterRepo.findById(id).get();
//		requiredResponse.setCenter(center);
//		
//		List<Citizen> listOfCitizens = restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);
//		requiredResponse.setCitizens(listOfCitizens);
//		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
//	}
//	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<RequiredResponse> getAllDadaBasedonCenterId(@PathVariable("id") Integer id) {
		RequiredResponse requiredResponse = new RequiredResponse();
		// 1st get vaccination center detail
		VaccinationCenter center = vaccinationCenterRepo.findById(id).get();
		requiredResponse.setCenter(center);

		// then get all citizen registerd to vaccination center

		@SuppressWarnings("unchecked")
		List<Citizen> listOfCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, List.class);
		requiredResponse.setCitizens(listOfCitizens);
		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
	}

}
