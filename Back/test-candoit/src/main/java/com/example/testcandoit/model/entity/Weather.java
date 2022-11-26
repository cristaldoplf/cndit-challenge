package com.example.testcandoit.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Weather implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double humidity;
    private Double st;
    private Double visibility;
    private Double wind_speed;
    private String description;
    private Double temp;
    private String wing_deg;
    private String tempDesc;

    public Weather() {
        //no args constructor
    }

    public Weather(Integer id, Double humidity, Double st, Double visibility, Double wind_speed, String description, Double temp, String wing_deg, String tempDesc) {
        this.id = id;
        this.humidity = humidity;
        this.st = st;
        this.visibility = visibility;
        this.wind_speed = wind_speed;
        this.description = description;
        this.temp = temp;
        this.wing_deg = wing_deg;
        this.tempDesc = tempDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getSt() {
        return st;
    }

    public void setSt(Double st) {
        this.st = st;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getWing_deg() {
        return wing_deg;
    }

    public void setWing_deg(String wing_deg) {
        this.wing_deg = wing_deg;
    }

    public String getTempDesc() {
        return tempDesc;
    }

    public void setTempDesc(String tempDesc) {
        this.tempDesc = tempDesc;
    }
}
