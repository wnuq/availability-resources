package com.wnuq.example.drivers.resources;

import com.wnuq.example.drivers.resource.policy.ResourcePolicyFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourcesConfiguration {

    @Bean
    public ResourcesFacade resourcesFacade(ResourcePolicyFacade resourcePolicyFacade) {
        return new ResourcesFacade(resourcePolicyFacade);
    }
}
