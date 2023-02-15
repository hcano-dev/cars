package com.hcano.cars.dto;

import com.hcano.cars.domain.shared.WordMother;
import com.hcano.cars.dto.brand.BrandEditPayload;

public class BrandRequestMother {
    public static BrandEditPayload create(String name) {
        return new BrandEditPayload(name);
    }

    public static BrandEditPayload random() {
        return create(WordMother.random(40));
    }
}
