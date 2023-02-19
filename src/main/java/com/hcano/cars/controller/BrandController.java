package com.hcano.cars.controller;

import com.hcano.cars.dto.brand.BrandEditPayload;
import com.hcano.cars.dto.brand.BrandPayload;
import com.hcano.cars.mapper.BrandMapper;
import com.hcano.cars.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(BrandController.URL)
public class BrandController {
    public static final String URL = "/brands";
    public static final String URL_ID = "/{id}";

    @Autowired
    BrandService service;

    @Autowired
    BrandMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BrandPayload> getAllBrands() {
        return mapper.toListOfDTOs(service.findAll());
    }

    @GetMapping(URL_ID)
    @ResponseStatus(HttpStatus.OK)
    public BrandPayload getBrandById(@PathVariable UUID id) {
        return mapper.toDTO(service.findById(id.toString()));
    }

    @PutMapping(URL_ID)
    @ResponseStatus(HttpStatus.CREATED)
    public void createBrand(@PathVariable UUID id, @RequestBody BrandEditPayload brandEditPayload) {
        service.create(id.toString(), mapper.toEntity(brandEditPayload));
    }

    @DeleteMapping(URL_ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrand(@PathVariable UUID id) {
        service.delete(id.toString());
    }
}
