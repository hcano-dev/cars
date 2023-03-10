package com.hcano.cars.dto.car;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcano.cars.dto.PayloadID;
import com.hcano.cars.dto.brand.BrandPayload;
import com.hcano.cars.dto.extra.ExtraPayload;
import com.hcano.cars.dto.price.PricePayload;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class CarPayload extends PayloadID {
    public CarPayload(String id, String model, BrandPayload brand, String color, Integer cc, Integer hp, List<PricePayload> prices, List<ExtraPayload> extras, Date created, Date modified) {
        super(id);
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.cc = cc;
        this.hp = hp;
        this.prices = prices;
        this.extras = extras;
        this.created = created;
        this.modified = modified;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonProperty(value = "created")
    private Date created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonProperty(value = "modified")
    private Date modified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarPayload)) return false;
        CarPayload that = (CarPayload) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, brand, color, cc, hp, prices, extras);
    }
}
