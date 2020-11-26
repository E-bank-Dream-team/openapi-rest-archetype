package ${package}.api;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import ${package}.controllers.AppController;

@RunWith(MockitoJUnitRunner.class)
public abstract class RestBase {
	
	@InjectMocks
	AppController appController;
	
	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(
				MockMvcBuilders.standaloneSetup(appController));
	}
	
}