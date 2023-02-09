package ru.nabokovsg.adminservice.mappers.pipelines;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.pipelines.*;
import ru.nabokovsg.adminservice.models.pipelines.PipelinePassport;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PipelinePassportMapper {

    PipelinePassport mapToNewPipelinePassport(NewPipelinePassportDto passportDto);

    PipelinePassport mapToUpdatePipelinePassport(UpdatePipelinePassportDto passportDto);

    PipelinePassportDto mapToPipelinePassportDto(PipelinePassport passport);

    List<ShortPipelinePassportDto> mapToShortPipelinePassportDto(List<PipelinePassport> passports);

    PipelineIdsDto mapToNewPipelineIdsDto(NewPipelinePassportDto passportDto);

    PipelineIdsDto mapToUpdatePipelineIdsDto(UpdatePipelinePassportDto passportDto);

    RequestIds mapToNewRequestIdsDto(NewPipelinePassportDto passportDto);

    RequestIds mapToUpdateRequestIdsDto(UpdatePipelinePassportDto passportDto);

}
