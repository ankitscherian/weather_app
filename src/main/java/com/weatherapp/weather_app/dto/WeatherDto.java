package com.weatherapp.weather_app.dto;

public record WeatherDto(
		String city,
		String country,
		double latitude,
		double longitude,
		double temperatureCelsius,
		double apparentTemperatureCelsius,
		double humidityPercent,
		double windSpeedKmh,
		double precipitationMm,
		String conditions) {
}