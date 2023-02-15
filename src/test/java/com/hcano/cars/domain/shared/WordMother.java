package com.hcano.cars.domain.shared;

import com.github.javafaker.Faker;

public class WordMother {
    public static String random(Integer maxLenght) {
        return Faker.instance().lorem().characters(1, maxLenght);
    }
}
