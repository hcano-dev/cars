package com.hcano.cars.controller.health_check;

import com.hcano.cars.controller.RequestTestCase;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class HealthCheckGetControllerShould extends RequestTestCase {
    @Test
    public void return_ok_status() throws Exception {
        assertResponse("/health-check", HttpStatus.OK.value(), "{'status':'ok'}");
    }
}
