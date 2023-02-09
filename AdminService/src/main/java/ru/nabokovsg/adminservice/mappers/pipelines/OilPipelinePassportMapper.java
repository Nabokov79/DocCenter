package ru.nabokovsg.adminservice.mappers.pipelines;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.pipelines.*;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.NewOilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.OilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.ShortOilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.UpdateOilPipelinePassportDto;
import ru.nabokovsg.adminservice.models.pipelines.OilPipelinePassport;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OilPipelinePassportMapper {

    OilPipelinePassport mapToNewOilPipelinePassport(NewOilPipelinePassportDto passportDto);

    OilPipelinePassport mapToUpdateOilPipelinePassport(UpdateOilPipelinePassportDto passportDto);

    OilPipelinePassportDto mapToOilPipelinePassportDto(OilPipelinePassport passport);

    List<ShortOilPipelinePassportDto> mapToShortOilPipelinePassportDto(List<OilPipelinePassport> passports);

    PipelineIdsDto mapToNewPipelineIdsDto(NewOilPipelinePassportDto passportDto);

    PipelineIdsDto mapToUpdatePipelineIdsDto(UpdateOilPipelinePassportDto passportDto);

    RequestIds mapToNewOilRequestIdsDto(NewOilPipelinePassportDto passportDto);

    RequestIds mapToUpdateRequestIdsDto(UpdateOilPipelinePassportDto passportDto);
}
