package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import com.app.Repository.weatherRepository;
import com.app.models.WeatherData;
@Service
@CrossOrigin("*")
public class WeatherService {

	
	@Autowired
	private weatherRepository weatherRepository;
	
	 private  RestTemplate restTemplate;


	 String apiurl = "https://api.openweathermap.org/data/2.5/weather?units=metric&q=";


	    public WeatherService(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    public String getWeatherByCity(String cityName) {
	        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?units=metric&q=" + cityName + "&appid=" + "f3ec760f890de6d7966c728c8a3b019b";
	        
	        
	        return restTemplate.getForObject(apiUrl, String.class);
	    }
	
	    public WeatherData insertData(WeatherData weatherData) {
	    	return weatherRepository.save(weatherData);
	    }
	    
	
}
