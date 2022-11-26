package com.example.testcandoit.model.dto;

public class WeatherDto {
    private Integer id;
    private Double temp;

    public WeatherDto(Integer id, Double temp) {
        this.id = id;
        this.temp = temp;
    }

    public WeatherDto() {
        //no-args constructor
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
