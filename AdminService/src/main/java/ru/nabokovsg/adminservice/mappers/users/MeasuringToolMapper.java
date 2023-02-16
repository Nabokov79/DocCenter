package ru.nabokovsg.adminservice.mappers.users;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.users.MeasuringToolDto;
import ru.nabokovsg.adminservice.dtos.users.MeasuringToolIds;
import ru.nabokovsg.adminservice.dtos.users.NewMeasuringToolDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateMeasuringToolDto;
import ru.nabokovsg.adminservice.models.users.MeasuringTool;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MeasuringToolMapper {

    MeasuringTool mapToNewMeasuringTool(NewMeasuringToolDto newMeasuringToolDto);

    MeasuringToolDto mapToMeasuringToolDto(MeasuringTool measuringTools);

    MeasuringTool mapToUpdateMeasuringTool(UpdateMeasuringToolDto measuringToolDto);

    List<MeasuringToolDto> mapToMeasuringToolsDto(List<MeasuringTool> newMeasuringTools);

    MeasuringToolIds mapToNeMeasuringToolValue(NewMeasuringToolDto newMeasuringToolDto);
    MeasuringToolIds mapToUpdateMeasuringToolValue(UpdateMeasuringToolDto measuringToolDto);
}
