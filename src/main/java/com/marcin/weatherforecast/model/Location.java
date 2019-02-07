package com.marcin.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    @JsonProperty("main")
    private Weather weather;

    public Weather getWeather(){
        return weather;
    }

    public void setWeather(Weather weather){
        this.weather = weather;
    }

}
