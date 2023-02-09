package ru.nabokovsg.adminservice.mappers.boilers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.boilers.BoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.NewBoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.ShortBoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.UpdateBoilerPassportDto;
import ru.nabokovsg.adminservice.models.boilers.BoilerPassport;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BoilerPassportMapper {

    BoilerPassport mapToNewBoilerPassport(NewBoilerPassportDto passportDto);

    BoilerPassportDto mapToBoilerPassportDto(BoilerPassport passport);

    BoilerPassport mapToUpdateBoilerPassport(UpdateBoilerPassportDto passportDto);

    List<ShortBoilerPassportDto> mapToShortBoilerPassportsDto(List<BoilerPassport> passports);

    RequestIds mapToNewRequestIdsDto(NewBoilerPassportDto passportDto);

    RequestIds mapToUpdateRequestIdsDto(UpdateBoilerPassportDto passportDto);

    BoilerPassport mapToBoilerPassport(@MappingTarget BoilerPassport passport, CommonDto commonDto);
}
