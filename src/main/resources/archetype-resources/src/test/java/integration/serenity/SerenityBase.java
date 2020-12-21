package ${package}.integration.serenity;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;

@RunWith(SpringIntegrationSerenityRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class SerenityBase {

}
