package com.hcano.cars.controller;

import com.hcano.cars.domain.shared.IdentifierMother;
import com.hcano.cars.dto.BrandRequestMother;
import com.hcano.cars.dto.CarRequestMother;
import com.hcano.cars.dto.CarResponseMother;
import com.hcano.cars.dto.brand.BrandEditPayload;
import com.hcano.cars.dto.car.CarEditPayload;
import com.hcano.cars.dto.car.CarPayload;
import com.hcano.cars.utils.JsonMapperUtils;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CarControllerTest extends RequestTestCase {
    @Test
    public void return_a_list_of_existing_cars() throws Exception {
        String id = IdentifierMother.random();
        CarEditPayload request = CarRequestMother.random();

        givenThereIsABrand(request.getBrand().getId(), BrandRequestMother.fromResponse(request.getBrand()));
        givenThereIsACar(id, request);

        assertResponse(
                CarController.URL,
                HttpStatus.OK.value(),
                JsonMapperUtils.mapToJson(List.of(CarResponseMother.fromRequest(id, request)))
        );
    }

    @Test
    public void return_an_existing_car() throws Exception {
        String id = IdentifierMother.random();
        CarEditPayload request = CarRequestMother.random();

        givenThereIsABrand(request.getBrand().getId(), BrandRequestMother.fromResponse(request.getBrand()));
        givenThereIsACar(id, request);

        CarPayload expectedResponse = CarResponseMother.fromRequest(id, request);

        assertResponse(
                String.format("%s/%s", CarController.URL, id),
                HttpStatus.OK.value(),
                JsonMapperUtils.mapToJson(expectedResponse)
        );
    }

    @Test
    public void return_a_non_existing_car() throws Exception {
        assertResponse(
                String.format("%s/%s", CarController.URL, IdentifierMother.random()),
                HttpStatus.PRECONDITION_FAILED.value(),
                ""
        );
    }

    @Test
    public void save_a_valid_car() throws Exception {
        String id = IdentifierMother.random();
        CarEditPayload request = CarRequestMother.random();

        givenThereIsABrand(request.getBrand().getId(), BrandRequestMother.fromResponse(request.getBrand()));

        assertRequestWithBody(
                HttpMethod.PUT.name(),
                String.format("%s/%s", CarController.URL, id),
                JsonMapperUtils.mapToJson(request),
                HttpStatus.CREATED.value()
        );
    }

    @Test
    public void delete_an_existing_car() throws Exception {
        String id = IdentifierMother.random();
        CarEditPayload car = CarRequestMother.random();

        givenThereIsABrand(car.getBrand().getId(), BrandRequestMother.fromResponse(car.getBrand()));
        givenThereIsACar(id, car);

        assertRequest(
                HttpMethod.DELETE.name(),
                String.format("%s/%s", CarController.URL, id),
                HttpStatus.NO_CONTENT.value()
        );
    }

    @Test
    public void delete_a_non_existing_car() throws Exception {
        assertRequest(
                HttpMethod.DELETE.name(),
                String.format("%s/%s", CarController.URL, IdentifierMother.random()),
                HttpStatus.PRECONDITION_FAILED.value()
        );
    }

    private void givenThereIsACar(String id, CarEditPayload car) throws Exception {
        assertRequestWithBody(
                HttpMethod.PUT.name(),
                String.format("%s/%s", CarController.URL, id),
                JsonMapperUtils.mapToJson(car),
                HttpStatus.CREATED.value()
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
