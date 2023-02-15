package com.hcano.cars.domain.shared;

import com.github.javafaker.Faker;

public class IntegerMother {
    public static Integer random(Integer countDigit) {
        return Integer.valueOf(Faker.instance().number().digits(countDigit));
    }
}
