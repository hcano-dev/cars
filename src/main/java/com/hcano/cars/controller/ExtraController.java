package com.hcano.cars.controller;

import com.hcano.cars.dto.extra.ExtraEditPayload;
import com.hcano.cars.mapper.ExtraMapper;
import com.hcano.cars.service.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(ExtraController.URL)
public class ExtraController {
    public static final String URL = "/extras";
    public static final String URL_ID = "/{id}";

    @Autowired
    ExtraService service;

    @Autowired
    ExtraMapper mapper;

    @PutMapping(ExtraController.URL_ID)
    @ResponseStatus(HttpStatus.CREATED)
    public void createExtra(@PathVariable UUID id, @RequestBody ExtraEditPayload extraEditPayload) {
        this.service.create(id, this.mapper.toEntity(extraEditPayload));
    }
}
