package com.hcano.cars.mapper;

import com.hcano.cars.dto.car.CarEditPayload;
import com.hcano.cars.dto.car.CarPayload;
import com.hcano.cars.model.domain.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarMapper {
    @Mapping(target = "model", source = "model")
    CarPayload toDTO(Car car);

    default List<CarPayload> toCarsPayload(List<Car> cars) {
        return cars.stream().map(this::toDTO).collect(Collectors.toList());
    }

    CarEditPayload toEditDTO(Car car);

    Car toEntity(CarEditPayload carEditPayload);
}
