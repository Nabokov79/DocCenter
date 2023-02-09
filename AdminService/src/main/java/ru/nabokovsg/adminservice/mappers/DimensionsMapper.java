package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.dimensions.DimensionsDto;
import ru.nabokovsg.adminservice.dtos.dimensions.NewDimensionsDto;
import ru.nabokovsg.adminservice.dtos.dimensions.UpdateDimensionsDto;
import ru.nabokovsg.adminservice.models.Dimensions;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DimensionsMapper {

    Dimensions mapToNewDimensions(NewDimensionsDto dimensionsDto);

    DimensionsDto mapToDimensionsDto(Dimensions dimensions);

    Dimensions mapToUpdateDimensions(UpdateDimensionsDto dimensionsDto);

    List<DimensionsDto> mapToDimensionsDto(List<Dimensions> dimensions);
}
