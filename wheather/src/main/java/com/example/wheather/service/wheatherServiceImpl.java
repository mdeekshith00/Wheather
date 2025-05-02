package com.example.wheather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.wheather.Entites.User;
import com.example.wheather.Entites.Wheather;


@Service
public class wheatherServiceImpl implements WheatherService{
	
	private static final String  apiKey = "513daafdefcb84c9e3816f8c9ce19c9c";
	private static final String  API  = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserserviceImpl UserserviceImpl;
	
	String getWheather = " ";
	String getLocation = " ";
	String getRegion = " ";
	String getcountry = " ";
	String thunderStromMessage = " ";
	String message1 = " ";
	String humadity = " ";
	String PressuerMessage = " ";
	
	
	
	
	
	public String getWheatherDetails(String city1) {
	Wheather reponse1 =  getWheather(city1);
	
	if(reponse1 != null) {
		getWheather = " Wheather feels like " +  reponse1.getCurrent().getTemperature();
		getLocation = " Location  is :" + reponse1.getLocation().getName();
		getRegion = " Region is :" + reponse1.getLocation().getRegion();
		getcountry = " County is " + reponse1.getLocation().getCountry();
		
		
		String s1 = getWheatherDetails(city1);
		String s2 = "";
		
		List<User> user = UserserviceImpl.getAllUser();
		for(int i=0; i<user.size(); i++) {
			if(user.get(i).getHomeLocation().equalsIgnoreCase(s1));
			System.out.println("is equals to Home location: " + user.get(i).getId());
		}
		
		
		if(reponse1.getCurrent().getWindSpeed() > 30  && reponse1.getCurrent().getHumidity() > 60  && reponse1.getCurrent().getPressure() < 1009) {
			thunderStromMessage = " it may causes Thunder strom : %n  Be Care Full  ";
			
		} 
		else if(reponse1.getCurrent().getTemperature() > 53 || reponse1.getCurrent().getTemperature() == 47) {
	
			message1 = "it is Highest Temperature in " + getLocation + " it causes dehydration, heat cramps, heat exhaustion, and potentially fatal heatstroke";
		}
		else if(reponse1.getCurrent().getHumidity() > 50) {
			humadity = "it's very hot day ,  it alomost " + reponse1.getCurrent().getHumidity() + " humadity today";	
		} 
		else if(reponse1.getCurrent().getPressure() <1009) {
			PressuerMessage = "its High Pressure ,  be CareFull.. ";
		}
		
	} 
	else {
		throw new InvalidMessage("you Enter details are invalid :");
	}
	return "Today "  + getWheather  + " ," +  getLocation + " ," +  getRegion + " ," + getcountry  +  thunderStromMessage + message1 + humadity + PressuerMessage;
	
	}
	
	
	public Wheather getWheather(String city) {
		String final_API  = API.replace("CITY", city).replace("API_KEY", apiKey);
		ResponseEntity<Wheather> reponse =	restTemplate.exchange(final_API, HttpMethod.GET, null ,Wheather.class );
		Wheather body =  reponse.getBody();
		return body;
	}


	@Override
	public void getMsgUser(String city1) {
		// TODO Auto-generated method stub
		String s1 = getWheatherDetails(city1);
		String s2 = "";
		
		List<User> user = UserserviceImpl.getAllUser();
		for(int i=0; i<user.size(); i++) {
			if(user.get(i).getHomeLocation().equalsIgnoreCase(s1));
			System.out.println("is equals to Home location: " + user.get(i).getId());
		}
		
		
	}

}
////List<User> user = UserserviceImpl.getAllUser();
//for(int i=0; i<user.size(); i++) {
//	if(user.get(i).getHomeLocation().equalsIgnoreCase(s1));
//	s2 =  "is equals to Home location: " + user.get(i).getId() ;
//}
//return s2;

	


	


