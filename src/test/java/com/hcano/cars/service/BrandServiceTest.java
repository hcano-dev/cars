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

import static org.mockito.BDDMockito.given;
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
    public void return_a_list_of_existing_brands() {
        this.service.findAll();

        verify(this.service.baseRepository, atLeastOnce()).findAll();
    }

    @Test
    public void return_an_existing_brand() {
        String id = IdentifierMother.random();

        given(service.baseRepository.existsById(id)).willReturn(true);

        this.service.findById(id);

        verify(this.service.baseRepository, atLeastOnce()).findById(id);
    }

    @Test
    public void save_a_valid_brand() {
        String id = IdentifierMother.random();
        BrandEditPayload request = BrandRequestMother.random();

        Brand brand = mapper.toEntity(request);

        this.service.create(id, brand);

        verify(this.service.baseRepository, atLeastOnce()).save(brand);
    }

    @Test
    public void delete_an_existing_brand() {
        String id = IdentifierMother.random();

        given(this.service.baseRepository.existsById(id)).willReturn(true);

        this.service.delete(id);

        verify(this.service.baseRepository, atLeastOnce()).deleteById(id);
    }
}
