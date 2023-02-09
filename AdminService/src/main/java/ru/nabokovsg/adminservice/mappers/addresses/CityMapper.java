package ru.nabokovsg.adminservice.mappers.addresses;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.addresses.citys.CityDto;
import ru.nabokovsg.adminservice.dtos.addresses.citys.NewCityDto;
import ru.nabokovsg.adminservice.dtos.addresses.citys.UpdateCityDto;
import ru.nabokovsg.adminservice.models.addresses.City;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City mapToNewCity(NewCityDto cityDto);

    CityDto mapToCityDto(City city);

    City mapToUpdateCity(UpdateCityDto cityDto);

    List<CityDto> mapToAuthorsDto(List<City> cities);
}
