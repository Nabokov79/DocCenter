package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.manufacturers.ManufacturerDto;
import ru.nabokovsg.adminservice.dtos.manufacturers.NewManufacturerDto;
import ru.nabokovsg.adminservice.dtos.manufacturers.UpdateManufacturerDto;

import java.util.List;

public interface ManufacturerService {

    ManufacturerDto save(NewManufacturerDto manufacturerDto);

    ManufacturerDto update(UpdateManufacturerDto manufacturerDto);

    List<ManufacturerDto> getAll();

    String delete(Long manId);
}
