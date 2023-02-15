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
    public CarEditPayload(String model, BrandPayload brand, String color, Integer cc, Integer hp, List<PricePayload> prices, List<ExtraPayload> extras) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.cc = cc;
        this.hp = hp;
        this.prices = prices;
        this.extras = extras;
    }

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
