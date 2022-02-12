package com.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.weather.repository.WeatherRepository;
import com.weather.services.WeatherService;

public class WeatherServiceTest {

	

	@Autowired
	private WeatherService service;

	@MockBean
	private WeatherRepository repository;
}
