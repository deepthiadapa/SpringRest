package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Country;

@RestController
public class HelloController {
	
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
	
}
