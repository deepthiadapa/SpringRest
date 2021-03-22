package com.cts.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cts.model.Country;
import com.cts.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
	ArrayList<Country> countries1=(ArrayList<Country>) context.getBean("countryList");
	
	public Country getCountry(String code) throws CountryNotFoundException{
		Country country = countries1.stream().filter(c-> c.getCode().equalsIgnoreCase(code)).findAny().orElse(null);
		if(country==null) {
			throw new CountryNotFoundException();
		}
		return country;
	}
}
