package com.TcgTask.weather.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final String apiKey = "your_api_key";

    private final String apiUrl = "https://api.openweathermap.org/data/2.5/weather";

    public String fetchWeatherData(String postalCode) {
        String url = String.format("%s?zip=%s,us&appid=%s&units=imperial", apiUrl, postalCode, apiKey);
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching weather data: " + e.getMessage());
        }
    }
}

