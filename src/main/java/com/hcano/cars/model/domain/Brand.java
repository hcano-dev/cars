package com.hcano.cars.model.domain;

import com.hcano.cars.utils.EqualsUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table
public class Brand extends BaseEntity {
    @Column(nullable = false, length = 36)
    private String name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsUtils.isEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created, modified);
    }
}
