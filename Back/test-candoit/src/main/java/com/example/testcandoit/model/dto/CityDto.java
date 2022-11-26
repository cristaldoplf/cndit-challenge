package com.example.testcandoit.model.dto;

import com.example.testcandoit.model.entity.Weather;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class CityDto {
    private String _id;
    private String name;
    private WeatherDto weather;



    public CityDto() {
        //no-args constructor
    }

    public CityDto(String _id, String name, WeatherDto weather) {
        this._id = _id;
        this.name = name;
        this.weather = weather;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeatherDto getWeather() {
        return weather;
    }

    public void setWeather(WeatherDto weather) {
        this.weather = weather;
    }
}
