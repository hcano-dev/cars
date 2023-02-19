package com.hcano.cars.dto;

import com.hcano.cars.domain.shared.IdentifierMother;
import com.hcano.cars.domain.shared.IntegerMother;
import com.hcano.cars.domain.shared.WordMother;
import com.hcano.cars.dto.brand.BrandPayload;
import com.hcano.cars.dto.car.CarEditPayload;
import com.hcano.cars.dto.car.CarPayload;
import com.hcano.cars.dto.extra.ExtraPayload;
import com.hcano.cars.dto.price.PricePayload;

import java.util.Date;
import java.util.List;

public class CarResponseMother {
    public static CarPayload create(String id, String model, BrandPayload brand, String color, Integer cc, Integer hp, List<PricePayload> prices, List<ExtraPayload> extras, Date created, Date modified) {
        return new CarPayload(id, model, brand, color, cc, hp, prices, extras, created, modified);
    }

    public static CarPayload random() {
        return create(
                IdentifierMother.random(),
                WordMother.random(40),
                BrandResponseMother.random(),
                WordMother.random(40),
                IntegerMother.random(4),
                IntegerMother.random(3),
                List.of(),
                List.of(),
                new Date(),
                new Date()
        );
    }

    public static CarPayload fromRequest(String id, CarEditPayload request) {
        return create(
                id,
                request.getModel(),
                request.getBrand(),
                request.getColor(),
                request.getCc(),
                request.getHp(),
                request.getPrices(),
                request.getExtras(),
                new Date(),
                new Date()
        );
    }
}
