package com.wnuq.example.drivers;

import com.wnuq.example.drivers.availability.AvailabilityFacade;
import com.wnuq.example.drivers.consents.ConsentsFacade;
import com.wnuq.example.drivers.resource.policy.ResourcePolicyFacade;
import com.wnuq.example.drivers.resources.ResourcesFacade;
import com.wnuq.example.drivers.trainings.TrainingsFacade;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.BDDAssertions.then;

@Transactional
@SpringBootTest
class AvailabilityApplicationTests {

	final Long RESOURCE_ID = 123L;

	@Autowired
	ResourcesFacade resourcesFacade;

	@Autowired
	ConsentsFacade consentFacade;

	@Autowired
	TrainingsFacade trainingsFacade;

	@Autowired
	ResourcePolicyFacade resourcePolicyFacade;

	@Autowired
	AvailabilityFacade availabilityFacade;

	@Test
	void shouldAllocateResourceCooperationAllModules() {
		//given
		resourcePolicyFacade.createResourcePolicy(RESOURCE_ID);

		//when
		resourcesFacade.skillsDefined(RESOURCE_ID);
		consentFacade.consentGiven(RESOURCE_ID);
		trainingsFacade.qualificationsConfirmed(RESOURCE_ID);

		//then
		var result = availabilityFacade.isResourceAvailable(RESOURCE_ID);

		then(result).isTrue();
	}
}
