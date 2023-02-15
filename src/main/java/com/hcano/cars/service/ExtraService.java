package com.hcano.cars.service;

import com.hcano.cars.model.domain.Extra;
import com.hcano.cars.model.repository.ExtraRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExtraService extends BaseService<Extra> {

    private ExtraRepository getBaseRepository() {
        return (ExtraRepository) baseRepository;
    }

    public Extra findById(String id) {
        this.checkById(id);

        Optional<Extra> extra = getBaseRepository().findById(id);

        if (extra.isEmpty()) {
            return null;
        }

        return extra.get();
    }

    public void create(UUID id, Extra extra) {
        extra.setId(id.toString());
        getBaseRepository().save(extra);
    }
}
