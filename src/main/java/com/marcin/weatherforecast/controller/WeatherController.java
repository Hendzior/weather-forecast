package com.marcin.weatherforecast.controller;

import com.marcin.weatherforecast.model.Weather;
import com.marcin.weatherforecast.service.OpenWeatherMapService;
import com.marcin.weatherforecast.service.WeatherService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;

@Controller
public class WeatherController {

    private WeatherService weatherService;

    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) @Nullable String city, ModelMap map) {

        setWeatherService(new OpenWeatherMapService());
        if (city != null && !city.equals("")) {
            try {
                Weather weather = weatherService.getCurrentWeather(city);
                map.addAttribute("weather", weather);
                map.addAttribute("city", city);
            } catch (RestClientException e) {
                map.addAttribute("message", e.getMessage());
            }
        }
        return "index";

    }

}
