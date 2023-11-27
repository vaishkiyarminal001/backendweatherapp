package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.WeatherData;
import com.app.services.WeatherService;

 
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class WeatherController {
	
	@Autowired
    private  WeatherService weatherService;

    @PostMapping("/insertData")
    public ResponseEntity<?> insertData(@Valid @RequestBody WeatherData weatherData){
    	
    	WeatherData w = weatherService.insertData(weatherData);
    	System.out.println(w);
//    	try {
    		return new ResponseEntity<WeatherData>(w, HttpStatus.CREATED);
//    	}
//    	catch{
//    		return new ResponseEntity<String>("Somthing went Wrong in storinging data", HttpStatus.BAD_REQUEST);
//    	}
    	
    }
   

//    @GetMapping("/weather/{city}")
//    public ResponseEntity<?>  getWeather(@PathVariable String city) {
//        String res =  weatherService.getWeatherByCity(city);
//         return new ResponseEntity<String>(res, HttpStatus.ACCEPTED);
//    }
}