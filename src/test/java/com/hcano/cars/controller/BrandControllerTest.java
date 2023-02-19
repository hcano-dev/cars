package com.hcano.cars.controller;

import com.hcano.cars.domain.shared.IdentifierMother;
import com.hcano.cars.dto.BrandRequestMother;
import com.hcano.cars.dto.BrandResponseMother;
import com.hcano.cars.dto.brand.BrandEditPayload;
import com.hcano.cars.dto.brand.BrandPayload;
import com.hcano.cars.utils.JsonMapperUtils;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.List;

public final class BrandControllerTest extends RequestTestCase {
    @Test
    public void return_a_list_of_existing_brands() throws Exception {
        String id = IdentifierMother.random();
        BrandEditPayload request = BrandRequestMother.random();

        givenThereIsABrand(id, request);

        List<BrandPayload> response = List.of(BrandResponseMother.fromRequest(id, request));

        assertResponse(
                BrandController.URL,
                HttpStatus.OK.value(),
                JsonMapperUtils.mapToJson(response)
        );
    }

    @Test
    public void return_an_empty_list_of_brands() throws Exception {
        List<BrandPayload> response = List.of();

        assertResponse(
                BrandController.URL,
                HttpStatus.OK.value(),
                JsonMapperUtils.mapToJson(response)
        );
    }

    @Test
    public void return_an_existing_brand() throws Exception {
        String id = IdentifierMother.random();
        BrandEditPayload request = BrandRequestMother.random();

        givenThereIsABrand(id, request);

        BrandPayload response = BrandResponseMother.fromRequest(id, request);

        assertResponse(
                String.format("%s/%s", BrandController.URL, id),
                HttpStatus.OK.value(),
                JsonMapperUtils.mapToJson(response)
        );
    }

    @Test
    public void return_a_non_existing_brand() throws Exception {
        String id = IdentifierMother.random();

        assertResponse(
                String.format("%s/%s", BrandController.URL, id),
                HttpStatus.PRECONDITION_FAILED.value(),
                ""
        );
    }

    @Test
    public void save_a_valid_brand() throws Exception {
        String id = IdentifierMother.random();
        BrandEditPayload request = BrandRequestMother.random();

        assertRequestWithBody(
                HttpMethod.PUT.name(),
                String.format("%s/%s", BrandController.URL, id),
                JsonMapperUtils.mapToJson(request),
                HttpStatus.CREATED.value()
        );
    }

    @Test
    public void delete_an_existing_brand() throws Exception {
        String id = IdentifierMother.random();
        BrandEditPayload brand = BrandRequestMother.random();

        givenThereIsABrand(id, brand);

        assertRequest(
                HttpMethod.DELETE.name(),
                String.format("%s/%s", BrandController.URL, id),
                HttpStatus.NO_CONTENT.value()
        );
    }

    @Test
    public void delete_a_non_existing_brand() throws Exception {
        String id = IdentifierMother.random();

        assertRequest(
                HttpMethod.DELETE.name(),
                String.format("%s/%s", BrandController.URL, id),
                HttpStatus.PRECONDITION_FAILED.value()
        );
    }

    private void givenThereIsABrand(String id, BrandEditPayload brand) throws Exception {
        assertRequestWithBody(
                HttpMethod.PUT.name(),
                String.format("%s/%s", BrandController.URL, id),
                JsonMapperUtils.mapToJson(brand),
                HttpStatus.CREATED.value()
        );
    }
}
