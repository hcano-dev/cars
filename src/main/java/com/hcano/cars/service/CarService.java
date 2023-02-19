package com.hcano.cars.service;

import com.hcano.cars.model.domain.Car;
import com.hcano.cars.model.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService extends BaseService<Car> {
    @Autowired
    BrandService brandService;

    public List<Car> getAll() {
        return getBaseRepository().findAll();
    }

    public Car findById(String id) {
        checkById(id);

        return getBaseRepository().findById(id).orElse(null);
    }

    public void create(String id, Car car) {
        brandService.checkById(car.getBrand().getId());

        car.setId(id);

        getBaseRepository().save(car);
    }

    private CarRepository getBaseRepository() {
        return (CarRepository) baseRepository;
    }

    public void delete(String id) {
        checkById(id);

        getBaseRepository().deleteById(id);
    }
}
