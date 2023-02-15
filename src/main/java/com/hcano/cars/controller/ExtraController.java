package com.hcano.cars.controller;

import com.hcano.cars.dto.extra.ExtraEditPayload;
import com.hcano.cars.dto.extra.ExtraPayload;
import com.hcano.cars.mapper.ExtraMapper;
import com.hcano.cars.service.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping(ExtraController.URL_ID)
    @ResponseStatus(HttpStatus.OK)
    public ExtraPayload getExtraById(@PathVariable UUID id) {
        return this.mapper.toDTO(this.service.findById(id.toString()));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExtraPayload> getAllExtras() {
        return this.mapper.toListOfDTOs(this.service.findAll());
    }

    @PutMapping(ExtraController.URL_ID)
    @ResponseStatus(HttpStatus.CREATED)
    public void createExtra(@PathVariable UUID id, @RequestBody ExtraEditPayload extraEditPayload) {
        this.service.create(id.toString(), this.mapper.toEntity(extraEditPayload));
    }

    @DeleteMapping(ExtraController.URL_ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExtra(@PathVariable UUID id) {
        this.service.delete(id.toString());
    }
}
