package ${package}.integration.serenity.steps;

import static org.hamcrest.Matchers.equalTo;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class SampleSteps {

    private static final String RESOURCE = "/api/v1/samples";

    @Step("Send a GET request")
    public void sendGet(String host) {
        SerenityRest.get(host + RESOURCE);
    }

    @Step("Response status code should be 200")
    public void responseStatusOk() {
        SerenityRest.restAssuredThat(resp -> resp.statusCode(equalTo(200)));
    }
}
