package ${package}.controllers;

import ${package}.generated.api.SampleApi;
import ${package}.generated.dto.SampleDto;
import ${package}.mappers.SampleMapper;
import ${package}.models.Sample;
import ${package}.services.SampleService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "sample")
@RestController
public class SampleController implements SampleApi {

	private final SampleService sampleService;
	private final SampleMapper sampleMapper;

	public SampleController(SampleService sampleService,
			SampleMapper sampleMapper) {

		this.sampleService = sampleService;
		this.sampleMapper = sampleMapper;
	}

	@Override
	public ResponseEntity<List<SampleDto>> getSamples() {
		return ResponseEntity.ok(sampleMapper.toListDto(sampleService.getAll()));
	}

	@Override
	public ResponseEntity<SampleDto> getSampleById(Long id) {
		Sample sample = sampleService.getOne(id);
		return ResponseEntity.ok(sampleMapper.toDto(sample));
	}
}
