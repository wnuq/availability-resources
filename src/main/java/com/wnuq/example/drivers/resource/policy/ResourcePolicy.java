package com.wnuq.example.drivers.resource.policy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

@Data
@Entity
@NoArgsConstructor
public class ResourcePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long resourceId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "phases", joinColumns = {@JoinColumn(name = "resource_policy_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "phase_type")
    @Column(name = "isCompleted")
    private Map<PhaseType, Boolean> phases;

    public ResourcePolicy(Long resourceId) {
        this.resourceId = resourceId;

        this.phases = stream(PhaseType.values())
                .collect(toMap(phase -> phase, phase -> false));
    }

    public void completePhase(PhaseType phaseType) {
        phases.put(phaseType, true);
    }

    public boolean isCompleted() {
        return phases.values().stream().allMatch(value -> value);
    }
}
