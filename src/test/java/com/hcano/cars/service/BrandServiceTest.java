package com.hcano.cars.service;

import com.hcano.cars.domain.shared.IdentifierMother;
import com.hcano.cars.dto.BrandRequestMother;
import com.hcano.cars.dto.brand.BrandEditPayload;
import com.hcano.cars.mapper.BrandMapper;
import com.hcano.cars.model.domain.Brand;
import com.hcano.cars.model.repository.BrandRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;

public class BrandServiceTest extends BaseServiceTest<Brand> {
    @Autowired
    BrandService service;

    @Autowired
    BrandMapper mapper;

    @Before
    public void setUp() {
        service.baseRepository = mock(BrandRepository.class);
    }

    @Test
    public void save_a_valid_brand() {
        String id = IdentifierMother.random();
        BrandEditPayload request = BrandRequestMother.random();

        Brand brand = mapper.toEntity(request);

        this.service.create(id, brand);

        shouldHaveSaved(brand);
    }

    private void shouldHaveSaved(Brand brand) {
        verify(service.baseRepository, atLeastOnce()).save(brand);
    }
}
