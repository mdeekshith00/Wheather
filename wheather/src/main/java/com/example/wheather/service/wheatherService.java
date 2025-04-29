package com.example.wheather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.wheather.Entites.Wheather;


@Component
public class wheatherService {
	private static final String  apiKey = "513daafdefcb84c9e3816f8c9ce19c9c";
	private static final String  API  = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Wheather getWheather(String city) {
		String final_API  = API.replace("CITY", city).replace("API_KEY", apiKey);
		ResponseEntity<Wheather> reponse =	restTemplate.exchange(final_API, HttpMethod.GET, null ,Wheather.class );
		Wheather body =  reponse.getBody();
		return body;
	}
	
//	public Wheather getWheatherByCity() {
//		String final_API  = API.replace("CITY").replace("API_KEY", apiKey);
//		
//	}

}
