package ru.nabokovsg.adminservice.services.pipelines;

import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.NewPurposePipelineDto;
import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.PurposePipelineDto;
import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.UpdatePurposePipelineDto;

import java.util.List;

public interface PurposePipelineService {

    PurposePipelineDto save(NewPurposePipelineDto purposePipeDto);

    PurposePipelineDto update(UpdatePurposePipelineDto purposePipeDto);

    List<PurposePipelineDto> getAll();

    String delete(Long purId);
}
