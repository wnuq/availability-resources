package com.wnuq.example.drivers.resource.policy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResourcePolicyService {

    private final ResourcePolicyRepository repository;

    public void create(Long resourceId) {
        repository.save(new ResourcePolicy(resourceId));
    }

    public void completePhase(Long resourceId, PhaseType phaseType) {
        var resourcePolicy = repository.findByResourceId(resourceId).orElseThrow();
        resourcePolicy.completePhase(phaseType);

        repository.save(resourcePolicy);
    }

    public boolean isResourceCanBeCreated(Long resourceId) {
        var resourcePolicy = repository.findByResourceId(resourceId).orElseThrow();
        return resourcePolicy.isCompleted();
    }
}
