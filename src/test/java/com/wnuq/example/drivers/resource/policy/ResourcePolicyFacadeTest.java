package com.wnuq.example.drivers.resource.policy;

import com.wnuq.example.drivers.availability.AvailabilityFacade;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static com.wnuq.example.drivers.resource.policy.PhaseType.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Transactional
@SpringBootTest
class ResourcePolicyFacadeTest {

    final Long RESOURCE_ID = 123L;

    @Autowired
    ResourcePolicyFacade resourcePolicyFacade;

    @MockBean
    AvailabilityFacade availabilityFacade;

    @Test
    void shouldAllocateResource() {
        //given
        resourcePolicyFacade.createResourcePolicy(RESOURCE_ID);

        //when
        resourcePolicyFacade.completePhase(RESOURCE_ID, RESOURCES);
        resourcePolicyFacade.completePhase(RESOURCE_ID, CONSENTS);
        resourcePolicyFacade.completePhase(RESOURCE_ID, TRAINING);

        //then
        verify(availabilityFacade, times(1)).create(RESOURCE_ID);
    }

    @Test
    void shouldNotAllocateResourceWhenNotAllStepsAreCompleted() {
        //given
        resourcePolicyFacade.createResourcePolicy(RESOURCE_ID);

        //when
        resourcePolicyFacade.completePhase(RESOURCE_ID, RESOURCES);
        resourcePolicyFacade.completePhase(RESOURCE_ID, CONSENTS);

        //then
        verify(availabilityFacade, times(0)).create(RESOURCE_ID);
    }
}