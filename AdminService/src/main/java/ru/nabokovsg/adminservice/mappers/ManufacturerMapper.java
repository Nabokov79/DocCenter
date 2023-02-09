package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.manufacturers.ManufacturerDto;
import ru.nabokovsg.adminservice.dtos.manufacturers.NewManufacturerDto;
import ru.nabokovsg.adminservice.dtos.manufacturers.UpdateManufacturerDto;
import ru.nabokovsg.adminservice.models.Manufacturer;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {

    Manufacturer mapToNewManufacturer(NewManufacturerDto manufacturerDto);

    ManufacturerDto mapToManufacturerDto(Manufacturer manufacturer);

    Manufacturer mapToUpdateManufacturer(UpdateManufacturerDto manufacturerDto);

    List<ManufacturerDto> mapToManufacturersDto(List<Manufacturer> manufacturers);
}
