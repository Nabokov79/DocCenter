package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.divisions.DivisionDto;
import ru.nabokovsg.adminservice.dtos.divisions.NewDivisionDto;
import ru.nabokovsg.adminservice.dtos.divisions.UpdateDivisionDto;

public interface DivisionService {

    DivisionDto save(NewDivisionDto divisionDto);

    DivisionDto update(UpdateDivisionDto divisionDto);

    DivisionDto get(Long divId);
}
