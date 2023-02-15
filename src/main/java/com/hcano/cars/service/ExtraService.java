package com.hcano.cars.service;

import com.hcano.cars.model.domain.Extra;
import com.hcano.cars.model.repository.ExtraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraService extends BaseService<Extra> {

    private ExtraRepository getBaseRepository() {
        return (ExtraRepository) baseRepository;
    }

    public List<Extra> findAll() {
        return this.getBaseRepository().findAll();
    }

    public Extra findById(String id) {
        this.checkById(id);

        Optional<Extra> extra = getBaseRepository().findById(id);

        if (extra.isEmpty()) {
            return null;
        }

        return extra.get();
    }

    public void create(String id, Extra extra) {
        extra.setId(id);
        getBaseRepository().save(extra);
    }

    public void delete(String id) {
        this.checkById(id);
        getBaseRepository().deleteById(id);
    }
}
