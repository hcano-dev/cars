package com.hcano.cars.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table
public class Brand extends BaseEntity {
    public Brand() {
        super(null, null, null);
    }

    public Brand(String id, String name, Date created, Date modified) {
        super(id, created, modified);

        this.name = name;
    }

    @Column(nullable = false, length = 36)
    private String name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand)) return false;
        Brand brand = (Brand) o;
        return id.equals(brand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created, modified);
    }
}
