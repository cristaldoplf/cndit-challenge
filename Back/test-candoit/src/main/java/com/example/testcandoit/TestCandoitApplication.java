package com.example.testcandoit;

import com.example.testcandoit.service.Impl.CityService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class TestCandoitApplication {

	public static void main(String[] args) throws UnirestException{
		SpringApplication.run(TestCandoitApplication.class, args);
	}

}
