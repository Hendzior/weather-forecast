package com.marcin.weatherforecast.service;

import com.marcin.weatherforecast.model.Location;
import com.marcin.weatherforecast.model.Weather;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class OpenWeatherMapService implements WeatherService {
    @Override
    public Weather getCurrentWeather(String city) {

        RestTemplate restTemplate = new RestTemplate();

        try {
            Location location = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + city + ",pl&appid=ef2028e98b54649bf1f4c4582631f350", Location.class);
            return location.getWeather();
        }catch (RestClientException e){
           throw new RestClientException("Nie znaleziono miasta: "+city);
        }
    }
}
