package ${package}.integration;

import ${package}.integration.serenity.SerenityBase;
import ${package}.integration.serenity.steps.SampleSteps;

import com.example.logger.AppLogger;
import org.junit.Test;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Value;

import net.thucydides.core.annotations.Steps;

public class SampleIT extends SerenityBase {

    @Steps
    private SampleSteps sampleSteps;

    @Value("${it.host}")
    private String host;

    @LocalServerPort
    private int serverPort;

    @Test
    public void getSampleTest() {
        // When
        AppLogger.info("!!!  Host:" + host);
        AppLogger.info("!!!  Port:" + serverPort);

        sampleSteps.sendGet(host + ":" + serverPort);

        // Then
        sampleSteps.responseStatusOk();
    }
}
