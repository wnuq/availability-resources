package com.wnuq.example.drivers.resource.policy;

import com.wnuq.example.drivers.availability.AvailabilityFacade;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResourcePolicyFacade {

    private final AvailabilityFacade availabilityFacade;

    private final ResourcePolicyService resourcePolicyService;

    public void createResourcePolicy(Long resourceId) {
        resourcePolicyService.create(resourceId);
    }

    public void completePhase(Long resourceId, PhaseType phaseType) {
        resourcePolicyService.completePhase(resourceId, phaseType);

        if(resourcePolicyService.isResourceCanBeCreated(resourceId)) {
            availabilityFacade.create(resourceId);
        }
    }
}
