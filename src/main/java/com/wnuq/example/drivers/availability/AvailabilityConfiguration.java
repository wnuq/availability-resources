package com.wnuq.example.drivers.availability;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvailabilityConfiguration {

    @Bean
    public AvailabilityFacade availabilityFacade(AvailabilityResourceRepository availabilityResourceRepository) {
        return new AvailabilityFacade(availabilityResourceRepository);
    }
}
