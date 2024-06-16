package com.wnuq.example.drivers.availability;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class AvailabilityResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long resourceId;

    private Boolean blockade;

    public AvailabilityResource(Long resourceId) {
        this.resourceId = resourceId;
        this.blockade = false;
    }

    public void block() {
        blockade = true;
    }

    public void release() {
        blockade = false;
    }

    public boolean isResourceAvailable() {
        return !blockade;
    }
}
