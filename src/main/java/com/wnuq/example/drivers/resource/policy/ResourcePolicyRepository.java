package com.wnuq.example.drivers.resource.policy;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourcePolicyRepository extends JpaRepository<ResourcePolicy, Long> {
    Optional<ResourcePolicy> findByResourceId(Long resourceId);
}
