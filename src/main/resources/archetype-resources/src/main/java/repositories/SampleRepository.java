package ${package}.repositories;

import ${package}.models.Sample;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SampleRepository extends JpaRepository<Sample, Long> {

	@Override
	List<Sample> findAll();

}
