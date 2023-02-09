package com.hcano.cars.model.domain;

import com.hcano.cars.utils.EqualsUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table
public class Price extends BaseEntity {
    @Column(name = "init_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date initDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(nullable = false)
    private BigInteger amount;

    @Override
    public boolean equals(Object o) {
        return EqualsUtils.isEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, initDate, endDate, amount);
    }
}
