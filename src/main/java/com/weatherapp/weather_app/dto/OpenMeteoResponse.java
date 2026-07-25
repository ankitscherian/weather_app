package com.weatherapp.weather_app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OpenMeteoResponse(CurrentWeather current) {

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record CurrentWeather(
			@JsonProperty("temperature_2m") double temperature,
			@JsonProperty("relative_humidity_2m") double humidity,
			@JsonProperty("apparent_temperature") double apparentTemperature,
			double precipitation,
			@JsonProperty("weather_code") int weatherCode,
			@JsonProperty("wind_speed_10m") double windSpeed) {
	}

}