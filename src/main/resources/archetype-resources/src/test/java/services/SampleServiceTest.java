package ${package}.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import javax.persistence.EntityNotFoundException;

import ${package}.mappers.SampleMapper;
import ${package}.mappers.SampleMapperImpl;
import ${package}.models.Sample;
import ${package}.repositories.SampleRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SampleServiceTest {

    @Mock
    SampleRepository sampleRepository;

    @InjectMocks
    SampleService sampleService;

    @Spy
    SampleMapper sampleMapper = new SampleMapperImpl();

    private static List<Sample> samplesGenerator(int size) {
        return LongStream.rangeClosed(1L, (long)size).mapToObj((l) -> {
            Sample sample = new Sample();
            sample.setId(l);
            sample.setValue("value " + l);
            return sample;
        }).collect(Collectors.toList());
    }

    @Test
    public void get_all_samples_returns_list_of_samples() {
        List<Sample> samples = samplesGenerator(5);
        when(sampleRepository.findAll()).thenReturn(samples);

        assertThat(sampleService.getAll(), equalTo(sampleMapper.toListDto(samples)));
    }

    @Test
    public void get_one_sample_existing() {
        Sample sample = new Sample();
        sample.setId(1L);
        when(sampleRepository.findById(1L)).thenReturn(Optional.of(sample));

        assertThat(sampleService.getOne(1L), equalTo(sampleMapper.toDto(sample)));
    }

    @Test(expected = EntityNotFoundException.class)
    public void get_one_sample_nonexisting() {
        when(sampleRepository.findById(1L)).thenReturn(Optional.empty());
        sampleService.getOne(1l);
    }

}
