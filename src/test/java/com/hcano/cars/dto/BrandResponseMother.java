package com.hcano.cars.dto;

import com.hcano.cars.domain.shared.IdentifierMother;
import com.hcano.cars.domain.shared.WordMother;
import com.hcano.cars.dto.brand.BrandEditPayload;
import com.hcano.cars.dto.brand.BrandPayload;

import java.util.Date;

public class BrandResponseMother {
    public static BrandPayload create(String id, String name, Date created, Date modified) {
        return new BrandPayload(id, name, created, modified);
    }

    public static BrandPayload random() {
        return create(
                IdentifierMother.random(),
                WordMother.random(40),
                new Date(),
                new Date()
        );
    }

    public static BrandPayload fromRequest(String id, BrandEditPayload request) {
        return create(id, request.getName(), new Date(), new Date());
    }
}
