package com.hcano.cars.domain.shared;

import com.github.javafaker.Faker;

import java.util.Date;

public class DateMother {
    public static Date random() {
        return Faker.instance().date().birthday();
    }
}
