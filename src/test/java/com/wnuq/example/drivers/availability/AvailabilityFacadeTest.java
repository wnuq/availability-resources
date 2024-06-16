package com.wnuq.example.drivers.availability;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class AvailabilityFacadeTest {

    final Long RESOURCE_ID = 123L;

    @Autowired
    AvailabilityFacade availabilityFacade;

    @Test
    void create() {
        //when
        availabilityFacade.create(RESOURCE_ID);

        //then
        var result = availabilityFacade.isResourceAvailable(RESOURCE_ID);

        then(result).isTrue();
    }

    @Test
    void tryAllocateAvailability() {
        //given
        availabilityFacade.create(RESOURCE_ID);

        //when
        availabilityFacade.block(RESOURCE_ID);

        //then
        var result = availabilityFacade.isResourceAvailable(RESOURCE_ID);

        then(result).isFalse();
    }

    //....add more test
}