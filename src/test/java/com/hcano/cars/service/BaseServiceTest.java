package com.hcano.cars.service;

import com.hcano.cars.constants.ProfileConstants;
import com.hcano.cars.model.domain.BaseEntity;
import com.hcano.cars.model.repository.BaseRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = ProfileConstants.SPRING_PROFILE_TEST)
public abstract class BaseServiceTest<T extends BaseEntity> {
    @Autowired
    protected BaseRepository<T> baseRepository;
}
