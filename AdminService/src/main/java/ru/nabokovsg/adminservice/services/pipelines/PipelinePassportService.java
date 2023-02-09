package ru.nabokovsg.adminservice.services.pipelines;

import ru.nabokovsg.adminservice.dtos.pipelines.NewPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.PipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.ShortPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.UpdatePipelinePassportDto;

import java.util.List;

public interface PipelinePassportService {

    PipelinePassportDto save(NewPipelinePassportDto passportDto);

    PipelinePassportDto update(UpdatePipelinePassportDto passportDto);

    PipelinePassportDto get(Long pasId);

   List<ShortPipelinePassportDto> getAll(Long purposePipelineId,Long addressId, String location);

    void delete(Long pasId);
}
