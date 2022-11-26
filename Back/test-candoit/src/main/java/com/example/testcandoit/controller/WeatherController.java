package com.example.testcandoit.controller;

import com.example.testcandoit.model.dto.WeatherDto;
import com.example.testcandoit.service.Impl.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Weather")
@CrossOrigin
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody WeatherDto weatherDto){
        return new ResponseEntity<>(weatherService.create(weatherDto), HttpStatus.CREATED);
    }
}
