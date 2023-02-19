package com.hcano.cars.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Car extends BaseEntity {
    public Car() {
        super(null, null, null);
    }
    public Car(String id, String model, Brand brand, String color, Integer cc, Integer hp, Date created, Date modified) {
        super(id, created, modified);
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.cc = cc;
        this.hp = hp;
    }

    @Column(nullable = false, length = 40)
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({ "cars" })
    private Brand brand = new Brand();

    @Column(nullable = false, length = 40)
    private String color;

    @Column(nullable = false)
    private Integer cc;

    @Column(nullable = false)
    private Integer hp;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private List<Price> prices = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "car_extra", joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "extra_id"))
    private List<Extra> extras = new ArrayList<>();

    public void addPrice(Price price) {
        prices.add(price);
    }

    public void addExtra(Extra extra) {
        extras.add(extra);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return id.equals(car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, color, cc, hp, created, modified);
    }
}
