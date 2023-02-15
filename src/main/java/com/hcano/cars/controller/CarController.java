package com.hcano.cars.controller;

import com.hcano.cars.dto.car.CarEditPayload;
import com.hcano.cars.dto.car.CarPayload;
import com.hcano.cars.mapper.CarMapper;
import com.hcano.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(CarController.URL)
public class CarController {
    public static final String URL = "/cars";
    public static final String URL_ID = "/{id}";

    @Autowired
    CarService service;

    @Autowired
    CarMapper mapper;

    @GetMapping
    public List<CarPayload> getAllCars() {
        return mapper.toCarsPayload(service.getAll());
    }

    @PutMapping(URL_ID)
    public ResponseEntity<String> createCar(@PathVariable UUID id, @RequestBody CarEditPayload request) {
        service.create(id.toString(), mapper.toEntity(request));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
