package com.cognizant.LearnTodayRESTAPI.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.model.Student;
import com.cognizant.LearnTodayRESTAPI.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	
	StudentService service;
	
	
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	@GetMapping("/Student")
	public ResponseEntity<Object> getAllCourses(){
		
		return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
	}

	@PostMapping("/Student")
	public ResponseEntity<Object> postStudent(@RequestBody Student student){
		if(service.postStudent(student)) {
			return new ResponseEntity<Object>( HttpStatus.CREATED);
		}
		else {
		return new ResponseEntity<Object>( HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/Student/{id}")
	public ResponseEntity<Object> deleteStudentEnrollment(@PathVariable("id") int id) {
			if(service.deleteStudent(id))
			{
				return new ResponseEntity<Object>( HttpStatus.OK);
			}
			else {
		return new ResponseEntity<Object>("No enrollment information found", HttpStatus.NOT_FOUND);
			}
	}
}
