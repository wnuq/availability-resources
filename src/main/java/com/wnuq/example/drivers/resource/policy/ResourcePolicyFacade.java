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
        try {
            resourcePolicyService.completePhase(resourceId, phaseType);

            if (resourcePolicyService.isResourceCanBeCreated(resourceId)) {
                availabilityFacade.create(resourceId);
            }
        } catch (Exception e) {
            //TODO: Add rollback for resource policy and availability if something bad happen
        }
    }
}
