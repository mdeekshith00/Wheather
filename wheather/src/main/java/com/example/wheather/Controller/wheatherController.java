package com.example.wheather.Controller;

import java.util.Scanner;

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
		System.out.println("Enter Your Location : ");
		Scanner sc = new Scanner(System.in);
		String city1 = sc.next();
		Wheather reponse1 =  service.getWheather(city1);
		String getWheather = " ";
		String getLocation = " ";
		String getRegion = " ";
		String getcountry = " ";
		String message = " ";
		if(reponse1 != null) {
			getWheather = " Wheather feels like " +  reponse1.getCurrent().getTemperature();
			getLocation = " Location  is :" + reponse1.getLocation().getName();
			getRegion = " Region is :" + reponse1.getLocation().getRegion();
			getcountry = " County is " + reponse1.getLocation().getCountry();
			
			if(reponse1.getCurrent().getWindSpeed() > 30  && reponse1.getCurrent().getHumidity() > 60  && reponse1.getCurrent().getPressure() < 1009  ) {
				 message = " it may causes Thunder strom : %n  Be Care Full  ";
			} 
		} else {
			throw new InvalidMessage("you Enter details are invalid :");
		}
		return new ResponseEntity<>("Today "  + getWheather +" ," + message + " ," +  getLocation + " ," +  getRegion + " ," + getcountry , HttpStatus.OK );
		
	}
	

	
	
	

}
