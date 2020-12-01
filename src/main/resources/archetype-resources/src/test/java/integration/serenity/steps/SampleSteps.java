package ${package}.integration.serenity.steps;

import static org.hamcrest.Matchers.equalTo;

import ${package}.integration.serenity.endpoints.SampleEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

@Component
public class SampleSteps {

    @Autowired
    private SampleEndpoint endpoint;

    @Step("Send a GET request")
    public void sendGet() {
        SerenityRest.get(endpoint.getEndpoint());
    }

    @Step("Response status code should be 200")
    public void responseStatusOk() {
        SerenityRest.restAssuredThat(resp -> resp.statusCode(equalTo(200)));
    }
}
