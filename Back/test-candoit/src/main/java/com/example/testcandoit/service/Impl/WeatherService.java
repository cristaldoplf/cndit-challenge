package com.example.testcandoit.service.Impl;

import com.example.testcandoit.model.dto.WeatherDto;
import com.example.testcandoit.model.entity.Weather;
import com.example.testcandoit.repository.WeatherRepository;
import com.example.testcandoit.service.IWeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WeatherService implements IWeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public WeatherDto findById(Integer id) {
        return objectMapper.convertValue(weatherRepository.findById(id).get(), WeatherDto.class);
    }

    @Override
    public WeatherDto create(WeatherDto weatherDto) {
        Weather weather = objectMapper.convertValue(weatherDto, Weather.class);
        WeatherDto weatherDtoResp = objectMapper.convertValue(weatherRepository.save(weather), WeatherDto.class);
        return weatherDtoResp;
    }

    @Override
    public void deleteById(Integer id) {
        weatherRepository.deleteById(id);
    }

    @Override
    public WeatherDto update(WeatherDto weatherDto) {
        Weather weather = objectMapper.convertValue(weatherDto, Weather.class);
        WeatherDto weatherDtoResp = objectMapper.convertValue(weatherRepository.save(weather), WeatherDto.class);
        return weatherDtoResp;
    }

    @Override
    public Set<WeatherDto> findAll() {
        List<Weather> weatherList = weatherRepository.findAll();
        Set<WeatherDto> respList = new HashSet<>();
        for (Weather wea: weatherList) {
            respList.add(objectMapper.convertValue(wea, WeatherDto.class));
        }
        return respList;
    }
}
