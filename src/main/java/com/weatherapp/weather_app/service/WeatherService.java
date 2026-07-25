package com.weatherapp.weather_app.service;

import com.weatherapp.weather_app.dto.GeocodingResponse;
import com.weatherapp.weather_app.dto.OpenMeteoResponse;
import com.weatherapp.weather_app.dto.WeatherDto;
import com.weatherapp.weather_app.exception.CityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

	private static final String GEOCODING_URL = "https://geocoding-api.open-meteo.com/v1/search";
	private static final String FORECAST_URL = "https://api.open-meteo.com/v1/forecast";

	private final RestClient restClient;

	public WeatherService(RestClient restClient) {
		this.restClient = restClient;
	}

	public WeatherDto getWeatherForCity(String city) {
		GeocodingResponse.GeocodingResult location = geocode(city);
		OpenMeteoResponse.CurrentWeather current = fetchCurrentWeather(location.latitude(), location.longitude());

		return new WeatherDto(
				location.name(),
				location.country(),
				location.latitude(),
				location.longitude(),
				current.temperature(),
				current.apparentTemperature(),
				current.humidity(),
				current.windSpeed(),
				current.precipitation(),
				WeatherCodeTranslator.describe(current.weatherCode()));
	}

	private GeocodingResponse.GeocodingResult geocode(String city) {
		GeocodingResponse response = restClient.get()
				.uri(GEOCODING_URL + "?name={city}&count=1&language=en&format=json", city)
				.retrieve()
				.body(GeocodingResponse.class);

		if (response == null || response.results() == null || response.results().isEmpty()) {
			throw new CityNotFoundException(city);
		}
		return response.results().get(0);
	}

	private OpenMeteoResponse.CurrentWeather fetchCurrentWeather(double latitude, double longitude) {
		OpenMeteoResponse response = restClient.get()
				.uri(FORECAST_URL
						+ "?latitude={lat}&longitude={lon}"
						+ "&current=temperature_2m,relative_humidity_2m,apparent_temperature,precipitation,weather_code,wind_speed_10m"
						+ "&timezone=auto",
						latitude, longitude)
				.retrieve()
				.body(OpenMeteoResponse.class);

		if (response == null || response.current() == null) {
			throw new IllegalStateException("Weather service returned no current conditions");
		}
		return response.current();
	}

}