package ${package}.api;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import ${package}.controllers.*;
import ${package}.mappers.*;
import ${package}.models.Sample;
import ${package}.services.SampleService;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public abstract class RestBase {

	@Mock
	SampleService sampleService;

	@Spy
	SampleMapper sampleMapper = new SampleMapperImpl();

	@InjectMocks
	SampleController sampleController;

	@InjectMocks
	AppController appController;

	@Before
	public void setup() {
		given(sampleService.getOne(1L)).willReturn(getSample(1L));
		given(sampleService.getAll()).willReturn(getSamples());

		RestAssuredMockMvc.standaloneSetup(
				MockMvcBuilders.standaloneSetup(appController, sampleController));
	}

	private List<Sample> getSamples() {
		return List.of(
				getSample(1L),
				getSample(2L),
				getSample(3L),
				getSample(4L));
	}

	private Sample getSample(Long id) {
		Sample sample = new Sample();
		sample.setId(id);
		sample.setValue(String.format("sampleValue%d", id));
		return sample;
	}

}
