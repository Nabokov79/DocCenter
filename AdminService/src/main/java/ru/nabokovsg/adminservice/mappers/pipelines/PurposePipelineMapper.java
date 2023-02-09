package ru.nabokovsg.adminservice.mappers.pipelines;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.NewPurposePipelineDto;
import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.PurposePipelineDto;
import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.UpdatePurposePipelineDto;
import ru.nabokovsg.adminservice.models.pipelines.PurposePipeline;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurposePipelineMapper {

    PurposePipeline mapToNewPurposePipeline(NewPurposePipelineDto purposePipelineDto);

    PurposePipelineDto mapToPurposePipelineDto(PurposePipeline purposePipeline);

    PurposePipeline mapToUpdatePurposePipeline(UpdatePurposePipelineDto purposePipelineDto);

    List<PurposePipelineDto> mapToPurposePipelinesDto(List<PurposePipeline> purposePipelines);
}
