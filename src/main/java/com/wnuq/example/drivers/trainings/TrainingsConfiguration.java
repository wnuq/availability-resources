package com.wnuq.example.drivers.trainings;

import com.wnuq.example.drivers.resource.policy.ResourcePolicyFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrainingsConfiguration {

    @Bean
    public TrainingsFacade trainingsFacade(ResourcePolicyFacade resourcePolicyFacade) {
        return new TrainingsFacade(resourcePolicyFacade);
    }
}
