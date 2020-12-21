package ${package}.integration;

import ${package}.integration.serenity.SerenityBase;
import ${package}.integration.serenity.steps.SampleSteps;
import ${package}.logger.AppLogger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import net.thucydides.core.annotations.Steps;

public class SampleIT extends SerenityBase {

    @Steps
    private SampleSteps sampleSteps;

    @Value("${it.host}")
    private String host;

    @Test
    public void getSampleTest() {
        // When
        AppLogger.info("!!!  Host:" + host);

        sampleSteps.sendGet(host);

        // Then
        sampleSteps.responseStatusOk();
    }
}
