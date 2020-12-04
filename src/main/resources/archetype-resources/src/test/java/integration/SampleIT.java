package ${package}.integration;

import ${package}.integration.serenity.SerenityBase;
import ${package}.integration.serenity.steps.SampleSteps;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.thucydides.core.annotations.Steps;

public class SampleIT extends SerenityBase {

    @Autowired
    @Steps
    private SampleSteps sample;

    @Test
    public void getSampleTest() {
        // When
        sample.sendGet();

        // Then
        sample.responseStatusOk();
    }
}
