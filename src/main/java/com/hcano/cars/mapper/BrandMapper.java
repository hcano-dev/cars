package com.hcano.cars.mapper;

import com.hcano.cars.dto.brand.BrandEditPayload;
import com.hcano.cars.dto.brand.BrandPayload;
import com.hcano.cars.model.domain.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BrandMapper {
    BrandPayload toDTO(Brand brand);

    Brand toEntity(BrandEditPayload brandEditPayload);
}
