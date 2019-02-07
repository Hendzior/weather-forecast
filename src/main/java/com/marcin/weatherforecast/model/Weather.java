package com.marcin.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


public class Weather {

    @JsonProperty("temp")
    private double temperatureInKalvin;

    public double getTemperatureInKalvin() {
        return temperatureInKalvin;
    }

    public void setTemperatureInKalvin(double temperatureInKalvin) {
        this.temperatureInKalvin = temperatureInKalvin;
        this.temperatureInCelsius = temperatureInKalvin - 272.15;
    }

    private double temperatureInCelsius;
    @JsonProperty("humidity")
    private double humidity;

    public Weather(){}

    public Weather(double temperatureInCelsius, double humidity) {
        this.temperatureInCelsius = temperatureInCelsius;
        this.humidity = humidity;
    }

    public double getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(double temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    public String getStringCelsius(){
        return String.format("%.2f", temperatureInCelsius);
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
