package com.example.testcandoit.utils;

import com.example.testcandoit.service.Impl.CityService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduling {

    @Autowired
    CityService cityService;

    @Scheduled(fixedRate = 300000)
    public void taskUpdateDatabase() throws UnirestException {
        cityService.updateCityInfo();

    }
}
