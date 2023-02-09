package ru.nabokovsg.adminservice.mappers.boilers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.boilers.BoilerDto;
import ru.nabokovsg.adminservice.dtos.boilers.NewBoilerDto;
import ru.nabokovsg.adminservice.dtos.boilers.UpdateBoilerDto;
import ru.nabokovsg.adminservice.models.boilers.Boiler;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoilerMapper {

    Boiler mapToNewBoiler(NewBoilerDto boilerDto);

    BoilerDto mapToBoilerDto(Boiler boiler);

    Boiler mapToUpdateBoiler(UpdateBoilerDto boilerDto);

    List<BoilerDto> mapToBoilersDto(List<Boiler> boilers);
}
