package ${package}.integration;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;

@RunWith(SerenityRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class SerenityBase {

    @Rule
    public SpringIntegrationMethodRule springIntegrationMethodRule = new SpringIntegrationMethodRule();

}
