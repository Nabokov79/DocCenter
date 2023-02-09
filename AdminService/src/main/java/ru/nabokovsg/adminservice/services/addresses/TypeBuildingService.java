package ru.nabokovsg.adminservice.services.addresses;

import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.NewTypeBuildingDto;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.TypeBuildingDto;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.UpdateTypeBuildingDto;
import java.util.List;

public interface TypeBuildingService {

    TypeBuildingDto save(NewTypeBuildingDto typeBuildingDto);

    TypeBuildingDto update(UpdateTypeBuildingDto typeBuildingDto);

    List<TypeBuildingDto> getAll();

    void delete(Long buiId);
}
