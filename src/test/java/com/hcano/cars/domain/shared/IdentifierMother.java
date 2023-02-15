package com.hcano.cars.domain.shared;

import java.util.UUID;

public class IdentifierMother {
    public static String random() {
        return UUID.randomUUID().toString();
    }
}
