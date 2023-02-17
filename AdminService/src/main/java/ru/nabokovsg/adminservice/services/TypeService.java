package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.types.NewTypeDto;
import ru.nabokovsg.adminservice.dtos.types.TypeDto;
import ru.nabokovsg.adminservice.dtos.types.UpdateTypeDto;

import java.util.List;

public interface TypeService {


    TypeDto save(NewTypeDto typeDto);

    TypeDto update(UpdateTypeDto typeDto);

    List<TypeDto> getAll();
}
