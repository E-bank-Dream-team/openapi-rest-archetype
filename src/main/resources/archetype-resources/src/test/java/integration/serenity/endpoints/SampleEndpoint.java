package ${package}.integration.serenity.endpoints;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SampleEndpoint {

    private static final String RESOURCE = "/api/v1/samples";
    private final String endpoint;

    public SampleEndpoint(@Value("${it.host}") String host) {
        endpoint = host + RESOURCE;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
