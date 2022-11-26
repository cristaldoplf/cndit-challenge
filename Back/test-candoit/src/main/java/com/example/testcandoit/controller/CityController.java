package com.example.testcandoit.controller;

import com.example.testcandoit.model.dto.CityDto;

import com.example.testcandoit.service.Impl.CityService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
@CrossOrigin
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/viewAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CityDto city){
     return new ResponseEntity<>(cityService.create(city),HttpStatus.CREATED);
    }

    @GetMapping("/saveAll")
    public ResponseEntity<?> saveAll() throws UnirestException {
        cityService.updateCityInfo();
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }
}
