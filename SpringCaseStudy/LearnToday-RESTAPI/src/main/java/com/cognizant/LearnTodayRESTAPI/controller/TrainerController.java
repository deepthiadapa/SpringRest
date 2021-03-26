package com.cognizant.LearnTodayRESTAPI.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.model.Trainer;
import com.cognizant.LearnTodayRESTAPI.service.TrainerService;

@RestController
@RequestMapping("/api/")
public class TrainerController {

	
	TrainerService service;
	

	public TrainerController(TrainerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/Trainer")
	public ResponseEntity<Object> trainerSignUp(@RequestBody Trainer trainer) {
		boolean signUp = service.trainerSignUp(trainer);
		if (signUp)
			return new ResponseEntity<>(trainer, HttpStatus.CREATED);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/Trainer/{id}")
	public ResponseEntity<Object> updatePassword(@PathVariable("id") int id, @RequestBody Trainer trainer){
		String r = service.updatePassword(id, trainer);
		if(r.equals("updated")) {
			return new ResponseEntity<>("Data updated successfully",HttpStatus.OK);
		}
		if(r.equals("notfound")) {
			return new ResponseEntity<>("Searched Data Not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
