package com.hcano.cars.service.car;

import com.hcano.cars.exception.PreconditionFailedException;
import com.hcano.cars.model.domain.BaseEntity;
import com.hcano.cars.model.repository.BaseRepository;

public class BaseService <T extends BaseEntity> {
    protected BaseRepository<T> baseRepository;

    public void checkById(Integer id) {
        if (id == null) {
            throw new PreconditionFailedException("Id cannot be null.");
        }

        if (!this.baseRepository.existsById(id)) {
            throw new PreconditionFailedException(String.format("Resouce with id [%s] not found.", id));
        }
    }
}
