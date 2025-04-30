package com.example.wheather.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wheather.Entites.Wheather;
import com.example.wheather.service.wheatherServiceImpl;

@RestController
@RequestMapping("/wheather")
public class wheatherController {
	
	@SuppressWarnings("unused")
	@Autowired
	private wheatherServiceImpl service;
	
	@GetMapping("/get/{city1}")
	public ResponseEntity<?> getWheatherDetails(@PathVariable String city1) {
      return new ResponseEntity<>(service.getWheatherDetails(city1) , HttpStatus.OK);
		
	}
	

	
	
	

}
