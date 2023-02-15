package com.hcano.cars.mapper;

import com.hcano.cars.dto.price.PricePayload;
import com.hcano.cars.model.domain.Price;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapper {
    PricePayload toDTO(Price price);
}
