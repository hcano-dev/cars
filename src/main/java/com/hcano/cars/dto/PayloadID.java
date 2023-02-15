package com.hcano.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
public class PayloadID implements Payload {
    @UUID
    @JsonProperty("id")
    protected String id;

    public PayloadID(String id) {
        this.id = id;
    }
}
