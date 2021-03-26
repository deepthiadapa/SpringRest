package com.cognizant.LearnTodayRESTAPI.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.service.CourseService;

@RestController
@RequestMapping("/api/")
public class AdminController {
	
	CourseService service;
	
	
	public AdminController(CourseService service) {
		super();
		this.service = service;
	}
	@GetMapping("/Admin")
	public ResponseEntity<Object> getAllCourses(){
		return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
	}
	
	@GetMapping("/Admin/{courseId}")
	public ResponseEntity<Object> getCourseById(@PathVariable("courseId") int courseId){
		Course course = service.getCourseById(courseId);
		if(course!=null) {
			return new ResponseEntity<>(course, HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>("Searched Data Not Found", HttpStatus.NOT_FOUND);
		}
	}
	
}
