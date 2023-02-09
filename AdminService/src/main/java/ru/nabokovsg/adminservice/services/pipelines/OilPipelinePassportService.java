package ru.nabokovsg.adminservice.services.pipelines;

import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.NewOilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.OilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.ShortOilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.UpdateOilPipelinePassportDto;

import java.util.List;

public interface OilPipelinePassportService {

    OilPipelinePassportDto save(NewOilPipelinePassportDto passportDto);

    OilPipelinePassportDto update(UpdateOilPipelinePassportDto passportDto);

    OilPipelinePassportDto get(Long pasId);

    List<ShortOilPipelinePassportDto> getAll();

    void delete(Long pasId);
}
