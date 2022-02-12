package com.weather.controllers;

//import java.lang.System.Logger;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.models.Weather;
import com.weather.services.WeatherService;

@RestController
@RequestMapping("api/weather")
public class WeatherController {
	
	
	org.jboss.logging.Logger logger = LoggerFactory.logger(WeatherController.class);

	@Autowired
	private WeatherService service;
	
	@PostMapping
	public ResponseEntity<?> saveWeather(@Valid @RequestBody Weather weather) {
		service.save(weather);
		logger.info("Add the Weather details| Controller");
		return ResponseEntity.ok(weather);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateWeather(@PathVariable("id")int id,@Valid @RequestBody Weather weather) {
		weather.setId(id);
		service.save(weather);
		logger.info("Update the Weather details by id| Controller");
		return ResponseEntity.ok("Updated successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(String city) {
		logger.info("Get Weather details by City| Controller");
		return ResponseEntity.ok(service.findByCity(city));
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteByCity(String city) {
		service.deleteData(city);
		logger.info("To delete the Weather details by City");
		return ResponseEntity.ok("Deleted successfully");
	}
}
