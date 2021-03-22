package com.cts.model;




import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Country {
	@NotNull

	@Size(min=2, max=2, message="Country code should be 2 characters")
	private String code;
	private String name;
	
	Logger logger=LoggerFactory.getLogger(Country.class);
	public Country() {
		logger.debug("Inside Country Constructor");
		
	}
	
	public Country(String name, String code, List countryList) {
		super();
		this.name = name;
		this.code = code;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

	
	
	
	
	
}
