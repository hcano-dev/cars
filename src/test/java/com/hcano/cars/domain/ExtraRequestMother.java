package com.hcano.cars.domain;

import com.hcano.cars.domain.shared.WordMother;
import com.hcano.cars.dto.extra.ExtraEditPayload;

public class ExtraRequestMother {
    public static ExtraEditPayload create(String name) {
        return new ExtraEditPayload(name);
    }

    public static ExtraEditPayload random() {
        return create(WordMother.random(40));
    }
}
