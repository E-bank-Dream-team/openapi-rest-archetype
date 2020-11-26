package ${package}.services;

import ${package}.models.Sample;
import ${package}.repositories.SampleRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SampleService {

	private final SampleRepository sampleRepository;

	public SampleService(SampleRepository sampleRepository) {
		this.sampleRepository = sampleRepository;
	}

	public List<Sample> getAll() {
		return sampleRepository.findAll();
	}

	public Sample getOne(Long id) {
		return sampleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
}