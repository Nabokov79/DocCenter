package ru.nabokovsg.adminservice.mappers.tanks;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.tanks.TankIdsDto;
import ru.nabokovsg.adminservice.dtos.tanks.passport.NewTankPassportDto;
import ru.nabokovsg.adminservice.dtos.tanks.passport.ShortTankPassportDto;
import ru.nabokovsg.adminservice.dtos.tanks.passport.TankPassportDto;
import ru.nabokovsg.adminservice.dtos.tanks.passport.UpdateTankPassportDto;
import ru.nabokovsg.adminservice.models.tanks.TankPassport;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TankPassportMapper {

    TankPassport mapToNewTankPassports(NewTankPassportDto passportDto);

    TankPassportDto mapToTankPassportDto(TankPassport passport);

    TankPassport mapToUpdateTankPassport(UpdateTankPassportDto passportDto);

    List<ShortTankPassportDto> mapToShortTankPassportsDto(List<TankPassport> passports);

    TankIdsDto mapToNewIdsDto(NewTankPassportDto passportDto);

    TankIdsDto mapToUpdateIdsDto(UpdateTankPassportDto passportDto);

    RequestIds mapToNewRequestIdsDto(NewTankPassportDto passportDto);

    RequestIds mapToUpdateRequestIdsDto(UpdateTankPassportDto passportDto);

    TankPassport mapToTankPassport(@MappingTarget TankPassport passport, CommonDto commonDto);
}