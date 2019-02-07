package com.marcin.weatherforecast.service;

import com.marcin.weatherforecast.model.Weather;

public class WeatherHardcoreService implements WeatherService{

    @Override
    public Weather getCurrentWeather(String city) {
        return new Weather(12.00, 60.00);

    }
}
