package com.hcano.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayloadID implements Payload {
    @JsonProperty("id")
    protected Integer id;
}
