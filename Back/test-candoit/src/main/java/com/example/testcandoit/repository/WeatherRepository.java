package com.example.testcandoit.repository;

import com.example.testcandoit.model.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
