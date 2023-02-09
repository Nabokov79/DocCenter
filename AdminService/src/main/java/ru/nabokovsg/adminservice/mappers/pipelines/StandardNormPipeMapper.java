package ru.nabokovsg.adminservice.mappers.pipelines;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.NewStandardNormPipeDto;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.StandardNormPipeDto;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.UpdateStandardNormPipeDto;
import ru.nabokovsg.adminservice.models.pipelines.StandardNormPipe;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StandardNormPipeMapper {

    List<StandardNormPipe> mapToNewStandardNormPipe(List<NewStandardNormPipeDto> pipesDto);

    List<StandardNormPipe> mapToUpdateStandardNormPipe(List<UpdateStandardNormPipeDto> pipesDto);

    List<StandardNormPipeDto> mapToStandardNormPipesDto(List<StandardNormPipe> standardNormPipes);
}
