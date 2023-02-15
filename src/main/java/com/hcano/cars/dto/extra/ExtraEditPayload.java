package com.hcano.cars.dto.extra;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcano.cars.dto.Payload;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ExtraEditPayload implements Payload {

    public ExtraEditPayload() {
    }

    public ExtraEditPayload(String name) {
        this.name = name;
    }

    @NotBlank
    @JsonProperty("name")
    private String name;
}
