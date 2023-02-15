package com.hcano.cars.dto;

import com.hcano.cars.domain.shared.IdentifierMother;
import com.hcano.cars.domain.shared.WordMother;
import com.hcano.cars.dto.extra.ExtraEditPayload;
import com.hcano.cars.dto.extra.ExtraPayload;

import java.util.Date;

public class ExtraResponseMother {
    public static ExtraPayload create(String id, String name, Date created, Date modified) {
        return new ExtraPayload(id, name, created, modified);
    }

    public static ExtraPayload random() {
        return create(
                IdentifierMother.random(),
                WordMother.random(40),
                new Date(),
                new Date()
        );
    }

    public static ExtraPayload fromRequest(String id, ExtraEditPayload request) {
        return new ExtraPayload(
                id,
                request.getName(),
                new Date(),
                new Date()
        );
    }
}
