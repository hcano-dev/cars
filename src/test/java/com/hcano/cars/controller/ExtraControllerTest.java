package com.hcano.cars.controller;

import com.hcano.cars.domain.ExtraRequestMother;
import com.hcano.cars.domain.ExtraResponseMother;
import com.hcano.cars.domain.shared.IdentifierMother;
import com.hcano.cars.dto.extra.ExtraEditPayload;
import com.hcano.cars.dto.extra.ExtraPayload;
import com.hcano.cars.utils.JsonMapperUtils;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;


public class ExtraControllerTest extends RequestTestCase {
    @Test
    public void save_a_valid_extra() throws Exception {
        String id = IdentifierMother.random();
        ExtraEditPayload request = ExtraRequestMother.random();

        assertRequestWithBody(
                HttpMethod.PUT.name(),
                String.format("/extras/%s", id),
                JsonMapperUtils.mapToJson(request),
                HttpStatus.CREATED.value()
        );
    }

}
