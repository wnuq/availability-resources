package com.wnuq.example.drivers.resources;

import com.wnuq.example.drivers.resource.policy.PhaseType;
import com.wnuq.example.drivers.resource.policy.ResourcePolicyFacade;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResourcesFacade {

    public ResourcePolicyFacade resourcePolicyFacade;

    public void skillsDefined(Long resourceId) {
        resourcePolicyFacade.completePhase(resourceId, PhaseType.RESOURCES);
    }
}
