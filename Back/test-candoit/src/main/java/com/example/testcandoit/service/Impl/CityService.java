package com.example.testcandoit.service.Impl;

import com.example.testcandoit.model.dto.CityDto;
import com.example.testcandoit.model.entity.City;
import com.example.testcandoit.repository.CityRepository;
import com.example.testcandoit.service.ICityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CityService implements ICityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public CityDto findById(Integer id) {

        return objectMapper.convertValue(cityRepository.findById(id).get(), CityDto.class);
    }

    @Override
    public CityDto create(CityDto cityDto) {
        City city = objectMapper.convertValue(cityDto, City.class);
        CityDto cityDtoResp = objectMapper.convertValue(cityRepository.save(city), CityDto.class);
        return cityDtoResp;
    }

    @Override
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    public CityDto update(CityDto cityDto) {
        City city = objectMapper.convertValue(cityDto, City.class);
        CityDto cityDtoResp = objectMapper.convertValue(cityRepository.save(city), CityDto.class);
        return cityDtoResp;
    }

    @Override
    public Set<CityDto> findAll() {
        List<City> cityList = cityRepository.findAll();
        Set<CityDto> respList = new HashSet<>();
        for (City city: cityList) {
            respList.add(objectMapper.convertValue(city, CityDto.class));
        }
        return respList;
    }

    public void updateAllCities(List<City> cityList){
        cityRepository.deleteAll();
        cityRepository.saveAll(cityList);
    }

    public void updateCityInfo() throws UnirestException{
        HttpResponse<String> response = Unirest.get("https://ws.smn.gob.ar/map_items/weather").asString();

        Gson gson = new Gson();

        Type listType = new TypeToken<List<City>>() {}.getType();
        List<City> cityList;
        cityList = gson.fromJson(response.getBody(), listType);

        updateAllCities(cityList);
    }




}
