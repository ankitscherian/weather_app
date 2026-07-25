package com.weatherapp.weather_app.controller;

import com.weatherapp.weather_app.dto.WeatherDto;
import com.weatherapp.weather_app.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

	private final WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@GetMapping("/api/weather")
	public WeatherDto getWeather(@RequestParam String city) {
		return weatherService.getWeatherForCity(city);
	}

}