package com.wnuq.example.drivers.availability;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AvailabilityFacade {

    private final AvailabilityResourceRepository repository;

    public void create(Long resourceId) {
        repository.save(new AvailabilityResource(resourceId));
    }

    public void block(Long resourceId) {
        var availabilityResource =  repository.findByResourceId(resourceId).orElseThrow();
        availabilityResource.block();

        repository.save(availabilityResource);
    }

    public void release(Long resourceId) {
        var availabilityResource =  repository.findByResourceId(resourceId).orElseThrow();
        availabilityResource.release();

        repository.save(availabilityResource);
    }

    public boolean isResourceAvailable(Long resourceId) {
        return repository.findByResourceId(resourceId)
                .orElseThrow()
                .isResourceAvailable();
    }
}
