package com.example.wheather.Controller;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.wheather.Entites.Wheather;
import com.example.wheather.service.wheatherService;

@RestController
@RequestMapping("/wheather")
public class wheatherController {
	
	@Autowired
	private wheatherService service;
	
	@GetMapping("/get")
	public ResponseEntity<?> getWheather() {
		Wheather reponse1 =  service.getWheather("Uk");
		String getWheather = " ";
		if(reponse1 != null) {
			getWheather = " Wheather feels like " +  reponse1.getCurrent().getTemperature();
		}
		return new ResponseEntity<>("hi "  + getWheather , HttpStatus.OK );
		
	}
	
	
	

}
