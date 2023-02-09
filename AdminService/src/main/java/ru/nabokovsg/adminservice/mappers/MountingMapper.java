package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.mounting.MountingDto;
import ru.nabokovsg.adminservice.dtos.mounting.NewMountingDto;
import ru.nabokovsg.adminservice.dtos.mounting.UpdateMountingDto;
import ru.nabokovsg.adminservice.models.Mounting;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MountingMapper {

    Mounting mapToNewMounting(NewMountingDto mountingDto);

    MountingDto mapToMountingDto(Mounting mounting);

    Mounting mapToUpdateMounting(UpdateMountingDto mountingDto);

    List<MountingDto> mapToMountingsDto(List<Mounting> mountings);
}
