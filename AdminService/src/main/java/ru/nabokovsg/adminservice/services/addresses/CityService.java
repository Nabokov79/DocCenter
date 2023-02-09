package ru.nabokovsg.adminservice.services.addresses;

import ru.nabokovsg.adminservice.dtos.addresses.citys.CityDto;
import ru.nabokovsg.adminservice.dtos.addresses.citys.NewCityDto;
import ru.nabokovsg.adminservice.dtos.addresses.citys.UpdateCityDto;

import java.util.List;

public interface CityService {

    CityDto save(NewCityDto cityDto);

    CityDto update(UpdateCityDto cityDto);

    List<CityDto> getAll();

    String delete(Long citId);
}
