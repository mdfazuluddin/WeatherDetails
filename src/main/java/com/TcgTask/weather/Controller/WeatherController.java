package com.TcgTask.weather.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TcgTask.weather.Dao.UserRequestRepository;
import com.TcgTask.weather.Model.UserRequest;
import com.TcgTask.weather.Service.WeatherService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private UserRequestRepository requestRepository;

    @Operation(summary = "Fetch weather data for a given postal code")
    @PostMapping("/fetch")
    public String fetchWeather(@RequestParam String postalCode, @RequestParam String userName) {
        System.out.println(postalCode + " " + userName);
        if (!postalCode.matches("\\d{5}")) {
            throw new IllegalArgumentException("Invalid postal code format. Please enter a 5-digit US postal code.");
        }
        String weatherData = weatherService.fetchWeatherData(postalCode);

        // Save to DB
        UserRequest request = new UserRequest(userName, postalCode, weatherData);
        requestRepository.save(request);

        return weatherData;
    }

    @Operation(summary = "Get history of weather By User Name")
    @GetMapping("/historyByUserName")
    public Iterable<UserRequest> getHistoryByUserName(@RequestParam(required = false) String userName) {
        if (userName != null) {
            return requestRepository.findByUserName(userName);
            // return requestRepository.findAll();
        }
        return requestRepository.findAll();
    }
    @Operation(summary = "Get history of weather By Postal Code")
    @GetMapping("/historyByPostCode")
    public Iterable<UserRequest> getHistoryByPostCode(@RequestParam(required = false) String postalCode) {
        if (postalCode != null) {
            return requestRepository.findByPostalCode(postalCode);
            // return requestRepository.findAll();
        }
        return requestRepository.findAll();
    }
    
}
