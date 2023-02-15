package com.hcano.cars.controller;

import com.hcano.cars.dto.ExtraRequestMother;
import com.hcano.cars.dto.ExtraResponseMother;
import com.hcano.cars.domain.shared.IdentifierMother;
import com.hcano.cars.dto.extra.ExtraEditPayload;
import com.hcano.cars.dto.extra.ExtraPayload;
import com.hcano.cars.utils.JsonMapperUtils;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.List;


public class ExtraControllerTest extends RequestTestCase {
    @Test
    public void return_a_list_of_existing_extras() throws Exception {
        String id = IdentifierMother.random();
        ExtraEditPayload request = ExtraRequestMother.random();

        givenThereIsAnExtra(id, request);

        List<ExtraPayload> response = List.of(ExtraResponseMother.fromRequest(id, request));

        assertResponse(
                ExtraController.URL,
                HttpStatus.OK.value(),
                JsonMapperUtils.mapToJson(response)
        );
    }

    @Test
    public void return_an_existing_extra() throws Exception {
        String id = IdentifierMother.random();
        ExtraEditPayload request = ExtraRequestMother.random();

        givenThereIsAnExtra(id, request);

        ExtraPayload response = ExtraResponseMother.fromRequest(id, request);

        assertResponse(
                String.format("/extras/%s", id),
                HttpStatus.OK.value(),
                JsonMapperUtils.mapToJson(response)
        );
    }

    @Test
    public void return_a_non_existing_extra() throws Exception {
        String id = IdentifierMother.random();
        assertRequest(
                HttpMethod.GET.name(),
                String.format("/extras/%s", id),
                HttpStatus.PRECONDITION_FAILED.value()
        );
    }

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

    @Test
    public void delete_an_existing_extra() throws Exception {
        String id = IdentifierMother.random();
        ExtraEditPayload request = ExtraRequestMother.random();

        givenThereIsAnExtra(id, request);

        assertRequest(
                HttpMethod.DELETE.name(),
                String.format("/extras/%s", id),
                HttpStatus.NO_CONTENT.value()
        );
    }

    @Test
    public void delete_a_non_existing_extra() throws Exception {
        String id = IdentifierMother.random();

        assertRequest(
                HttpMethod.DELETE.name(),
                String.format("/extras/%s", id),
                HttpStatus.PRECONDITION_FAILED.value()
        );
    }

    private void givenThereIsAnExtra(String id, ExtraEditPayload extra) throws Exception {
        assertRequestWithBody(
                HttpMethod.PUT.name(),
                String.format("/extras/%s", id),
                JsonMapperUtils.mapToJson(extra),
                HttpStatus.CREATED.value()
        );
    }

}
