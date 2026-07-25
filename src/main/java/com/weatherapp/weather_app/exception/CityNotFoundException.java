package com.weatherapp.weather_app.exception;

public class CityNotFoundException extends RuntimeException {

	public CityNotFoundException(String city) {
		super("Could not find a location matching '" + city + "'");
	}

}