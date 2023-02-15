package com.hcano.cars.service;

import com.hcano.cars.exception.PreconditionFailedException;
import com.hcano.cars.model.domain.BaseEntity;
import com.hcano.cars.model.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService <T extends BaseEntity> {
    @Autowired
    protected BaseRepository<T> baseRepository;

    public void checkById(String id) {
        if (id == null) {
            throw new PreconditionFailedException("Id cannot be null.");
        }

        if (!this.baseRepository.existsById(id)) {
            throw new PreconditionFailedException(String.format("Resouce with id [%s] not found.", id));
        }
    }
}
