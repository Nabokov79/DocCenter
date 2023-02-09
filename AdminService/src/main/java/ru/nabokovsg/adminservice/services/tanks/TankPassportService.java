package ru.nabokovsg.adminservice.services.tanks;

import ru.nabokovsg.adminservice.dtos.tanks.passport.*;

import java.util.List;

public interface TankPassportService {

    TankPassportDto save(NewTankPassportDto passportDto);

    TankPassportDto update(UpdateTankPassportDto passportDto);

    TankPassportDto get(Long pasId);

    List<ShortTankPassportDto> getAll(TankSearchParam param);

    void delete(Long pasId);
}
