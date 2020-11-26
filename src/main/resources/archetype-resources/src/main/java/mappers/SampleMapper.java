package ${package}.mappers;

import ${package}.generated.dto.SampleDto;
import ${package}.models.Sample;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SampleMapper {

	public abstract SampleDto toDto(Sample sample);

	public abstract List<SampleDto> toListDto(List<Sample> sample);
}