package com.example.wheather.Entites;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;




public class Wheather {
	private Current current;


	public Current getCurrent() {
		return current;
	}
	public void setCurrent(Current current) {
		this.current = current;
	}
	
	public class Current{
		
	    private int temperature;	   
	    
	    @JsonProperty("weather_descriptions")
	    private List<String> weatherDescriptions;

		public int getTemperature() {
			return temperature;
		}

		public void setTemperature(int temperature) {
			this.temperature = temperature;
		}

		public List<String> getWeatherDescriptions() {
			return weatherDescriptions;
		}

		public void setWeatherDescriptions(List<String> weatherDescriptions) {
			this.weatherDescriptions = weatherDescriptions;
		}
	   
//	    private String is_day;
	}

	

	
	
}



