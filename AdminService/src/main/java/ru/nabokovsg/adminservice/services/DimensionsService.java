package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.dimensions.DimensionsDto;
import ru.nabokovsg.adminservice.dtos.dimensions.NewDimensionsDto;
import ru.nabokovsg.adminservice.dtos.dimensions.UpdateDimensionsDto;

import java.util.List;

public interface DimensionsService {

    DimensionsDto save(NewDimensionsDto dimensionsDto);

    DimensionsDto update(UpdateDimensionsDto dimensionsDto);

    List<DimensionsDto> getAll();

    void delete(Long dimId);
}
