package com.example.wheather.Entites;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Wheather {
	private Current current;
	private Location location;


	public Current getCurrent() {
		return current;
	}
	public void setCurrent(Current current) {
		this.current = current;
	}
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}


	public class Current{
		
	    private int temperature;	   
	    
	    @JsonProperty("weather_descriptions")
	    private List<String> weatherDescriptions;
	    private String country;
	    @JsonProperty("is_day")
	    private String isDay;
	    @JsonProperty("ind_speed")
	    private int windSpeed;
	    private int humidity;
	    private int pressure;
	    

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

		public String getIsDay() {
			return isDay;
		}

		public void setIsDay(String isDay) {
			this.isDay = isDay;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public int getWindSpeed() {
			return windSpeed;
		}

		public void setWindSpeed(int windSpeed) {
			this.windSpeed = windSpeed;
		}

		public int getHumidity() {
			return humidity;
		}

		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}

		public int getPressure() {
			return pressure;
		}

		public void setPressure(int pressure) {
			this.pressure = pressure;
		}
		
		
		
	}
	public class Location {
		private String name;
		private String country;
	    private String region;
	    
	    
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
	    
	    
	}

	
	
}



