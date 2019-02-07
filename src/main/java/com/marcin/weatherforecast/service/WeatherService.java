package com.marcin.weatherforecast.service;

import com.marcin.weatherforecast.model.Weather;

public interface WeatherService {

    Weather getCurrentWeather(String city);


}
