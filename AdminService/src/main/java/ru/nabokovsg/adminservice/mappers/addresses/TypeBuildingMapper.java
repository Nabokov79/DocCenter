package ru.nabokovsg.adminservice.mappers.addresses;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.NewTypeBuildingDto;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.TypeBuildingDto;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.UpdateTypeBuildingDto;
import ru.nabokovsg.adminservice.models.addresses.TypeBuilding;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeBuildingMapper {

    TypeBuilding mapToNewTypeBuilding(NewTypeBuildingDto typeBuildingDto);

    TypeBuildingDto mapToTypeBuildingDto(TypeBuilding typeBuilding);

    TypeBuilding mapToUpdateTypeBuilding(UpdateTypeBuildingDto typeBuildingDto);

    List<TypeBuildingDto> mapToTypeBuildingsDto(List<TypeBuilding> typeBuildings);
}
