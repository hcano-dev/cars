package com.hcano.cars.controller;

import com.hcano.cars.dto.car.CarEditPayload;
import com.hcano.cars.dto.car.CarPayload;
import com.hcano.cars.mapper.CarMapper;
import com.hcano.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public List<CarPayload> getAllCars() {
        return this.mapper.toCarsPayload(this.service.getAll());
    }

    @GetMapping(URL_ID)
    @ResponseStatus(HttpStatus.OK)
    public CarPayload getCarById(@PathVariable UUID id) {
        return this.mapper.toDTO(this.service.findById(id.toString()));
    }

    @PutMapping(URL_ID)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCar(@PathVariable UUID id, @RequestBody CarEditPayload request) {
        this.service.create(id.toString(), this.mapper.toEntity(request));
    }

    @DeleteMapping(URL_ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable UUID id) {
        this.service.delete(id.toString());
    }
}
