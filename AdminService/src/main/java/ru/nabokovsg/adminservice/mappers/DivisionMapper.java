package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.DivisionIds;
import ru.nabokovsg.adminservice.dtos.divisions.DivisionDto;
import ru.nabokovsg.adminservice.dtos.divisions.NewDivisionDto;
import ru.nabokovsg.adminservice.dtos.divisions.UpdateDivisionDto;
import ru.nabokovsg.adminservice.models.Division;

@Mapper(componentModel = "spring")
public interface DivisionMapper {

    Division mapToNewDivision(NewDivisionDto divisionDto);

    DivisionDto mapToDivisionDto(Division division);

    Division mapToUpdateDivision(UpdateDivisionDto divisionDto);

    DivisionIds mapToNewDivisionIds(NewDivisionDto divisionDto);

    DivisionIds mapToUpdateDivisionIds(UpdateDivisionDto divisionDto);
}
