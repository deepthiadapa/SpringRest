package com.cts.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cts.model.Country;
import com.cts.SpringRest1Application;
import com.cts.service.CountryService;
import com.cts.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	@Autowired
	private Country country;
	@Autowired
	private List<Country> listCountries;
	
	Logger logger=LoggerFactory.getLogger(CountryController.class);
	@RequestMapping(value="/country")
	public Country getCountryIndia() {
		return country;
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		return listCountries;
	}
	@GetMapping("/countries/{code}")
	public Country getCountry(String code) {
		return country;
	}
	@PostMapping("/countries")
	public void addCountry(@RequestBody @Valid Country country) {
		logger.info("Start");
		/*ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
		Validator validator=factory.getValidator();
		Set<ConstraintViolation<Country>> violations=validator.validate(country);
		List<String> errors=new ArrayList<String>();
		for (ConstraintViolation<Country> violation : violations) {
			errors.add(violation.getMessage());
		}
		if(violations.size()>0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.toString());
		}*/
		listCountries.add(country);
		logger.debug("Country : {}",country.toString());
		logger.info("End");
		
		
		
	}
	
}
