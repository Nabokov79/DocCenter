package ru.nabokovsg.adminservice.services.pipelines;

import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.NewStandardNormPipeDto;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.StandardNormPipeDto;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.UpdateStandardNormPipeDto;

import java.util.List;

public interface StandardNormPipeService {

    List<StandardNormPipeDto> save(List<NewStandardNormPipeDto> pipesDto);

    List<StandardNormPipeDto> update(List<UpdateStandardNormPipeDto> pipesDto);

    List<StandardNormPipeDto> getAll(Long typeId);

    void delete(Long staId);
}
