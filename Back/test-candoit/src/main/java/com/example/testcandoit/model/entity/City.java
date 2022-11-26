package com.example.testcandoit.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class City implements Serializable {

    @Id
    private String _id;
    private Double dist;
    private Double lid;
    private Double fid;
    private Double int_number;
    private String name;
    private String province;
    private String lat;
    private String lon;
    private String zoom;
    private Double updated;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_weather", referencedColumnName = "id")
    private Weather weather;

    public City() {
        //no args constructor
    }

    public City(String _id, Double dist, Double lid, Double fid, Double int_number, String name, String province, String lat, String lon, String zoom, Double updated, Weather weather) {
        this._id = _id;
        this.dist = dist;
        this.lid = lid;
        this.fid = fid;
        this.int_number = int_number;
        this.name = name;
        this.province = province;
        this.lat = lat;
        this.lon = lon;
        this.zoom = zoom;
        this.updated = updated;
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + _id + '\'' +
                ", dist=" + dist +
                ", lid=" + lid +
                ", fid=" + fid +
                ", int_number=" + int_number +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", zoom='" + zoom + '\'' +
                ", updated=" + updated +
                ", weather=" + weather +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Double getDist() {
        return dist;
    }

    public void setDist(Double dist) {
        this.dist = dist;
    }

    public Double getLid() {
        return lid;
    }

    public void setLid(Double lid) {
        this.lid = lid;
    }

    public Double getFid() {
        return fid;
    }

    public void setFid(Double fid) {
        this.fid = fid;
    }

    public Double getInt_number() {
        return int_number;
    }

    public void setInt_number(Double int_number) {
        this.int_number = int_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getZoom() {
        return zoom;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

    public Double getUpdated() {
        return updated;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void setUpdated(Double updated) {
        this.updated = updated;
    }
}
