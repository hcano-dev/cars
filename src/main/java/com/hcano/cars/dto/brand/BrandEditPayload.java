package com.hcano.cars.dto.brand;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcano.cars.dto.Payload;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BrandEditPayload implements Payload {
    public BrandEditPayload() {}

    public BrandEditPayload(String name) {
        this.name = name;
    }

    @NotBlank
    @JsonProperty("name")
    private String name;
}
