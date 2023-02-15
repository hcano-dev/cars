package com.hcano.cars.mapper;

import com.hcano.cars.dto.extra.ExtraEditPayload;
import com.hcano.cars.dto.extra.ExtraPayload;
import com.hcano.cars.model.domain.Extra;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExtraMapper {
    ExtraPayload toDTO(Extra extra);

    Extra toEntity(ExtraEditPayload extraEditPayload);
}
