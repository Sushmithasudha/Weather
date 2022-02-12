package com.weather.services;

import java.lang.System.Logger;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.controllers.WeatherController;
import com.weather.models.Weather;
import com.weather.repository.WeatherRepository;

@Service
public class WeatherService {
	org.jboss.logging.Logger logger = LoggerFactory.logger(WeatherService.class);

	@Autowired
	private WeatherRepository repo;
	
	public void save(Weather we) {
		logger.info("To save the Weather details");
		repo.save(we);
	}
	
	public Weather getById(int id) {
		logger.info("Get Weather details by id");
		return repo.getById(id);
	}
	
	public List<Weather> getAll(){
		logger.info("Fetching all the Weather details");
		return repo.findAll();
	}
	
	public List<Weather> findByCity(String city){
		logger.info("Get Weather details by City");
		return repo.findByCity(city);
	}
	
	public void deleteData(String city) {
		logger.info("To delete the Weather details by City");
		List<Weather> data=repo.findByCity(city);
		repo.deleteAll(data);
	}
}
