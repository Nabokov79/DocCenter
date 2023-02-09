package ru.nabokovsg.adminservice.mappers.tanks;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.tanks.protections.NewProtectionsDto;
import ru.nabokovsg.adminservice.dtos.tanks.protections.ProtectionsDto;
import ru.nabokovsg.adminservice.dtos.tanks.protections.UpdateProtectionsDto;
import ru.nabokovsg.adminservice.models.tanks.Protections;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProtectionsMapper {

    Protections mapToNewProtections(NewProtectionsDto protectionsDto);

    ProtectionsDto mapToProtectionsDto(Protections protections);

    Protections mapToUpdateProtections(UpdateProtectionsDto protectionsDto);

    List<ProtectionsDto> mapToProtectionsDto(List<Protections> protections);
}
