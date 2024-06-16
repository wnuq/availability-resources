package com.wnuq.example.drivers.consents;

import com.wnuq.example.drivers.resource.policy.ResourcePolicyFacade;
import lombok.AllArgsConstructor;

import static com.wnuq.example.drivers.resource.policy.PhaseType.CONSENTS;

@AllArgsConstructor
public class ConsentsFacade {

    private final ResourcePolicyFacade resourcePolicyFacade;

    public void consentGiven(Long resourceId) {
        resourcePolicyFacade.completePhase(resourceId, CONSENTS);
    }
}
