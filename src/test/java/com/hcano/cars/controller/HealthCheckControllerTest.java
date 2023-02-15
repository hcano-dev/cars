package com.hcano.cars.controller;

import org.junit.Test;
import org.springframework.http.HttpStatus;

public class HealthCheckControllerTest extends RequestTestCase {
    @Test
    public void return_ok_status() throws Exception {
        assertResponse("/health-check", HttpStatus.OK.value(), "{'status':'ok'}");
    }
}
