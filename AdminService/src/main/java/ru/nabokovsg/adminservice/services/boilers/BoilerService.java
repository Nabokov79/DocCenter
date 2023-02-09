package ru.nabokovsg.adminservice.services.boilers;

import ru.nabokovsg.adminservice.dtos.boilers.BoilerDto;
import ru.nabokovsg.adminservice.dtos.boilers.NewBoilerDto;
import ru.nabokovsg.adminservice.dtos.boilers.UpdateBoilerDto;

import java.util.List;

public interface BoilerService {

    BoilerDto save(NewBoilerDto boilerDto);

    BoilerDto update(UpdateBoilerDto boilerDto);

    List<BoilerDto> getAll();

    void delete(Long boiId);
}
