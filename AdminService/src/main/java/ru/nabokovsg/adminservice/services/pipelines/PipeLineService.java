package ru.nabokovsg.adminservice.services.pipelines;


import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.pipelines.PipelineIdsDto;
import ru.nabokovsg.adminservice.models.pipelines.OilPipelinePassport;
import ru.nabokovsg.adminservice.models.pipelines.PipelinePassport;
import ru.nabokovsg.adminservice.models.pipelines.StandardNormPipe;

import java.util.List;

public interface PipeLineService {

    PipelinePassport setValuePipeline(PipelinePassport passportDto, PipelineIdsDto ids, RequestIds requestIds);

    OilPipelinePassport setValueOilPipeline(OilPipelinePassport passportDto, PipelineIdsDto ids, RequestIds requestIds);

    List<StandardNormPipe> setPurposePipeline(List<StandardNormPipe> pipes, List<Long> purposeIds);
}
