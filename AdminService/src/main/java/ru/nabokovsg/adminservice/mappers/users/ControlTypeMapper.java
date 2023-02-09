package ru.nabokovsg.adminservice.mappers.users;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.users.ControlTypeDto;
import ru.nabokovsg.adminservice.dtos.users.NewControlTypeDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateControlTypeDto;
import ru.nabokovsg.adminservice.models.users.ControlType;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ControlTypeMapper {

    ControlType mapToNewControlType(NewControlTypeDto typeControlDto);

    ControlTypeDto mapToControlTypeDto(ControlType typeControl);

    ControlType mapToUpdateControlType(UpdateControlTypeDto typeControlDto);

    List<ControlTypeDto> mapToControlTypesDto(List<ControlType> typeControls);
}
