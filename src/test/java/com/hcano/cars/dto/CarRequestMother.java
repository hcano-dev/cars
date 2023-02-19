package com.hcano.cars.dto;

import com.hcano.cars.domain.shared.IntegerMother;
import com.hcano.cars.domain.shared.WordMother;
import com.hcano.cars.dto.brand.BrandPayload;
import com.hcano.cars.dto.car.CarEditPayload;
import com.hcano.cars.dto.extra.ExtraPayload;
import com.hcano.cars.dto.price.PricePayload;

import java.util.List;

public class CarRequestMother {
    public static CarEditPayload create(String model, BrandPayload brand, String color, Integer cc, Integer hp, List<PricePayload> prices, List<ExtraPayload> extras) {
        return new CarEditPayload(model, brand, color, cc, hp, prices, extras);
    }

    public static CarEditPayload random() {
        return create(
                WordMother.random(40),
                BrandResponseMother.random(),
                WordMother.random(40),
                IntegerMother.random(4),
                IntegerMother.random(3),
                List.of(),
                List.of()
        );
    }
}
