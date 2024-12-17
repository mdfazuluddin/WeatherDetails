package com.TcgTask.weather.TcgTask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.TcgTask.weather.Service.WeatherService;

@SpringBootTest(classes = {com.TcgTask.weather.TcgTaskApplication.class})
class TcgTaskApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
    void testFetchWeatherData() {
        RestTemplate restTemplate = mock(RestTemplate.class);
        WeatherService weatherService = new WeatherService();
        String postalCode = "12345";

        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenReturn("Mock Weather Data");

        String result = weatherService.fetchWeatherData(postalCode);
        if(result != null){
            assertEquals(true, result.contains("weather"));
        }else{
            assertEquals("Mock Weather Data", result);
        }
    }

}
