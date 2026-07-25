package com.weatherapp.weather_app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeocodingResponse(List<GeocodingResult> results) {

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record GeocodingResult(String name, double latitude, double longitude, String country) {
	}

}
