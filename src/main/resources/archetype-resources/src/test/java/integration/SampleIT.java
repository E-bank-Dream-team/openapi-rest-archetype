package ${package}.integration;

import static org.hamcrest.Matchers.equalTo;

import ${package}.integration.SerenityBase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import net.serenitybdd.rest.SerenityRest;

public class SampleIT extends SerenityBase {

    private static final String RESOURCE = "/api/v1/samples";
    @Value("${it.host}")
    private String host;
    private final String endpoint = host + RESOURCE;

    @Test
    public void getSampleTest() {
        SerenityRest.get(endpoint);
        SerenityRest.restAssuredThat(resp -> resp.statusCode(equalTo(200)));
    }
}
