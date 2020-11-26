package ${package}.controllers;

import ${package}.generated.api.SampleApi;
import ${package}.generated.dto.SampleDto;
import ${package}.mappers.SampleMapper;
import ${package}.models.Sample;
import ${package}.repositories.SampleRepository;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Api(tags = "sample")
@RestController
public class SampleController implements SampleApi {

	private final SampleRepository sampleRepository;
	private final SampleMapper sampleMapper;

	public SampleController(SampleRepository sampleRepository,
			SampleMapper sampleMapper) {

		this.sampleRepository = sampleRepository;
		this.sampleMapper = sampleMapper;
	}

	@Override
	public ResponseEntity<List<SampleDto>> getSamples() {
		return ResponseEntity.ok(sampleMapper.toListDto(sampleRepository.findAll()));
	}

	@Override
	public ResponseEntity<SampleDto> getSampleById(Long id) {
		Sample sample = sampleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		return ResponseEntity.ok(sampleMapper.toDto(sample));
	}
}
