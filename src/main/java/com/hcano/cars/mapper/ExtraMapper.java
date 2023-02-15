package com.hcano.cars.mapper;

import com.hcano.cars.dto.extra.ExtraEditPayload;
import com.hcano.cars.dto.extra.ExtraPayload;
import com.hcano.cars.model.domain.Extra;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExtraMapper {
    ExtraPayload toDTO(Extra extra);

    Extra toEntity(ExtraEditPayload extraEditPayload);

    default List<ExtraPayload> toListOfDTOs(List<Extra> extras) {
        return extras.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
