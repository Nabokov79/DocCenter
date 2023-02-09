package ru.nabokovsg.adminservice.services.tanks;

import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.NewTankParametersDto;
import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.TankParametersDto;
import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.UpdateTankParametersDto;

import java.util.List;

public interface TankParametersService {

    TankParametersDto save(NewTankParametersDto tankParametersDto);

    TankParametersDto update(UpdateTankParametersDto tankParametersDto);

    List<TankParametersDto> getAll();

    void delete(Long parId);
}
