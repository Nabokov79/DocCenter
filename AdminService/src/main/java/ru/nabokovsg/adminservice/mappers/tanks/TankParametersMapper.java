package ru.nabokovsg.adminservice.mappers.tanks;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.NewTankParametersDto;
import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.TankParametersDto;
import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.UpdateTankParametersDto;
import ru.nabokovsg.adminservice.models.tanks.TankParameters;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TankParametersMapper {

    TankParameters mapToNewTankParameters(NewTankParametersDto tankParametersDto);

    TankParametersDto mapToTankParametersDto(TankParameters tankParameters);

    TankParameters mapToUpdateTankParameters(UpdateTankParametersDto tankParametersDto);

    List<TankParametersDto> mapToTankParametersDto(List<TankParameters> tankParameters);
}
