package com.wnuq.example.drivers;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class ModuleDependencyTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.wnuq.example.drivers");

    @Test
    void checkDependencies() {
        layeredArchitecture().consideringOnlyDependenciesInLayers()
                .layer("availability").definedBy("com.wnuq.example.drivers.availability..")
                .layer("resource.policy").definedBy("com.wnuq.example.drivers.resource.policy..")
                .layer("resources").definedBy("com.wnuq.example.drivers.resources..")
                .layer("trainings").definedBy("com.wnuq.example.drivers.trainings..")
                .layer("consents").definedBy("com.wnuq.example.drivers.consents..")
                .whereLayer("availability").mayNotAccessAnyLayer()
                .whereLayer("resource.policy").mayOnlyAccessLayers("availability")
                .whereLayer("resources").mayOnlyAccessLayers("resource.policy")
                .whereLayer("trainings").mayOnlyAccessLayers("resource.policy")
                .whereLayer("consents").mayOnlyAccessLayers("resource.policy")
                .check(classes);
    }
}
