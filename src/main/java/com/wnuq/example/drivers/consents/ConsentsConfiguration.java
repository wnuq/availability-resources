package com.wnuq.example.drivers.consents;

import com.wnuq.example.drivers.resource.policy.ResourcePolicyFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsentsConfiguration {

    @Bean
    public ConsentsFacade consentsFacade(ResourcePolicyFacade resourcePolicyFacade) {
        return new ConsentsFacade(resourcePolicyFacade);
    }
}
