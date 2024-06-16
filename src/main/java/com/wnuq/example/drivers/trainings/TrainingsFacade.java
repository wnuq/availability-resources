package com.wnuq.example.drivers.trainings;

import com.wnuq.example.drivers.resource.policy.ResourcePolicyFacade;
import lombok.AllArgsConstructor;

import static com.wnuq.example.drivers.resource.policy.PhaseType.TRAINING;

@AllArgsConstructor
public class TrainingsFacade {

    private final ResourcePolicyFacade resourcePolicyFacade;

    public void qualificationsConfirmed(Long resourceId) {
        resourcePolicyFacade.completePhase(resourceId, TRAINING);
    }

}
