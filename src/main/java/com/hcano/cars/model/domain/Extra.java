package com.hcano.cars.model.domain;

import com.hcano.cars.utils.EqualsUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table
public class Extra extends BaseEntity {
    @Column(nullable = false, length = 36)
    private String name;

    @Override
    public boolean equals(Object o) {
        return EqualsUtils.isEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
