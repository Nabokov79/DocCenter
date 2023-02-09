package ru.nabokovsg.adminservice.mappers.pipelines;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.models.pipelines.OilPipelinePassport;
import ru.nabokovsg.adminservice.models.pipelines.PipelinePassport;

@Mapper(componentModel = "spring")
public interface PipelineMapper {

    PipelinePassport mapToPipelinePassport(@MappingTarget PipelinePassport passport, CommonDto commonDto);

    OilPipelinePassport mapToOilPipelinePassport(@MappingTarget OilPipelinePassport passport, CommonDto commonDto);
}
