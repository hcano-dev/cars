package com.hcano.cars.service;

import com.hcano.cars.model.domain.Brand;
import com.hcano.cars.model.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService extends BaseService<Brand> {
    public List<Brand> findAll() {
        return getBaseRepository().findAll();
    }

    public Brand findById(String id) {
        this.checkById(id);

        Optional<Brand> brand = getBaseRepository().findById(id);

        return brand.orElse(null);
    }

    public void create(String id, Brand brand) {
        brand.setId(id);

        getBaseRepository().save(brand);
    }

    public void delete(String id) {
        checkById(id);

        getBaseRepository().deleteById(id);
    }

    private BrandRepository getBaseRepository() {
        return (BrandRepository) baseRepository;
    }
}
