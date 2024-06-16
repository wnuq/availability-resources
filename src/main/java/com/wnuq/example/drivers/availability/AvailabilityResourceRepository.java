package com.wnuq.example.drivers.availability;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvailabilityResourceRepository extends JpaRepository<AvailabilityResource, Long> {
    Optional<AvailabilityResource> findByResourceId(Long resourceId);
}
