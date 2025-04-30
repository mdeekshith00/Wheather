package com.example.wheather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;import org.springframework.web.client.RestTemplate;

import com.example.wheather.Entites.Wheather;


@Service
public class wheatherServiceImpl implements WheatherService{
	
	private static final String  apiKey = "513daafdefcb84c9e3816f8c9ce19c9c";
	private static final String  API  = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getWheatherDetails(String city1) {
	Wheather reponse1 =  getWheather(city1);
	String getWheather = " ";
	String getLocation = " ";
	String getRegion = " ";
	String getcountry = " ";
	String message = " ";
	String message1 = " ";
	
	
	if(reponse1 != null) {
		getWheather = " Wheather feels like " +  reponse1.getCurrent().getTemperature();
		getLocation = " Location  is :" + reponse1.getLocation().getName();
		getRegion = " Region is :" + reponse1.getLocation().getRegion();
		getcountry = " County is " + reponse1.getLocation().getCountry();
		
		if(reponse1.getCurrent().getWindSpeed() > 30  && reponse1.getCurrent().getHumidity() > 60  && reponse1.getCurrent().getPressure() < 1009  ) {
			 message = " it may causes Thunder strom : %n  Be Care Full  ";
		} else if(reponse1.getCurrent().getTemperature() > 53 || reponse1.getCurrent().getTemperature() > 47) {
			message1 = "it is Highest Temperature in " + getLocation + " it causes dehydration, heat cramps, heat exhaustion, and potentially fatal heatstroke";
		} 
		
	}
	else {
		throw new InvalidMessage("you Enter details are invalid :");
	}
	return "Today "  + getWheather  + " ," +  getLocation + " ," +  getRegion + " ," + getcountry  +  message;
	
	}
	
	
	public Wheather getWheather(String city) {
		String final_API  = API.replace("CITY", city).replace("API_KEY", apiKey);
		ResponseEntity<Wheather> reponse =	restTemplate.exchange(final_API, HttpMethod.GET, null ,Wheather.class );
		Wheather body =  reponse.getBody();
		return body;
	}

}
