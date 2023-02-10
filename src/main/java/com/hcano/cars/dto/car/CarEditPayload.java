package com.hcano.cars.dto.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcano.cars.dto.Payload;
import com.hcano.cars.dto.brand.BrandPayload;
import com.hcano.cars.dto.extra.ExtraPayload;
import com.hcano.cars.dto.price.PricePayload;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class CarEditPayload implements Payload {
    @NotBlank
    @JsonProperty("model")
    private String model;

    @NotNull
    @JsonProperty(value = "brand")
    private BrandPayload brand;

    @NotBlank
    @JsonProperty("color")
    private String color;

    @NotNull
    @JsonProperty("cc")
    private Integer cc;

    @NotNull
    @JsonProperty("hp")
    private Integer hp;

    @NotNull
    @JsonProperty("prices")
    private List<PricePayload> prices;

    @JsonProperty("extras")
    private List<ExtraPayload> extras;
}
