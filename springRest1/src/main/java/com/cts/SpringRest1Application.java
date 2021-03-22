package com.cts;

import java.util.ArrayList;

//import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.model.Country;

@SpringBootApplication
@ImportResource({"classpath:country.xml"})
public class SpringRest1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRest1Application.class, args);
		displayCountry();
		displayCountries();
	}
	
	

	private static void displayCountry() {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = (Country) context.getBean("country", Country.class);
		System.out.println("Handson1");
		System.out.println(country);
		System.out.println("Handson2");
		System.out.println(anotherCountry);
	}
	private static void displayCountries() {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		@SuppressWarnings("unchecked")
		ArrayList<Country> countryList1=(ArrayList<Country>) context.getBean("countryList",ArrayList.class);
		System.out.println("Handson3");
		for(Country countries:countryList1) {
			System.out.println(countries);
		}
	}
	}


