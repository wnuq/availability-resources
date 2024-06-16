package com.wnuq.example.drivers.resource.policy;

import com.wnuq.example.drivers.availability.AvailabilityFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourcePolicyConfiguration {

    @Bean
    public ResourcePolicyFacade resourcePolicyFacade(ResourcePolicyService resourcePolicyService,
                                                     AvailabilityFacade availabilityFacade) {
        return new ResourcePolicyFacade(availabilityFacade, resourcePolicyService);
    }

    @Bean
    public ResourcePolicyService resourcePolicyService(ResourcePolicyRepository repository) {
        return new ResourcePolicyService(repository);
    }
}
