package com.weatherapp.weather_app.service;

import java.util.Map;

class WeatherCodeTranslator {

	// WMO weather interpretation codes used by Open-Meteo.
	private static final Map<Integer, String> DESCRIPTIONS = Map.ofEntries(
			Map.entry(0, "Clear sky"),
			Map.entry(1, "Mainly clear"),
			Map.entry(2, "Partly cloudy"),
			Map.entry(3, "Overcast"),
			Map.entry(45, "Fog"),
			Map.entry(48, "Depositing rime fog"),
			Map.entry(51, "Light drizzle"),
			Map.entry(53, "Moderate drizzle"),
			Map.entry(55, "Dense drizzle"),
			Map.entry(61, "Slight rain"),
			Map.entry(63, "Moderate rain"),
			Map.entry(65, "Heavy rain"),
			Map.entry(71, "Slight snow fall"),
			Map.entry(73, "Moderate snow fall"),
			Map.entry(75, "Heavy snow fall"),
			Map.entry(80, "Slight rain showers"),
			Map.entry(81, "Moderate rain showers"),
			Map.entry(82, "Violent rain showers"),
			Map.entry(95, "Thunderstorm"),
			Map.entry(96, "Thunderstorm with slight hail"),
			Map.entry(99, "Thunderstorm with heavy hail"));

	private WeatherCodeTranslator() {
	}

	static String describe(int weatherCode) {
		return DESCRIPTIONS.getOrDefault(weatherCode, "Unknown");
	}

}