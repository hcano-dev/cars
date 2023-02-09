package com.hcano.cars.model.domain;

import com.hcano.cars.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    protected Integer id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date created;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date modified;

    @PrePersist
    public void prePersist() {
        created = DateUtils.now();
        modified = DateUtils.now();
    }
}
