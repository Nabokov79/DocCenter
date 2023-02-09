package ru.nabokovsg.adminservice.services.filters;

import ru.nabokovsg.adminservice.dtos.filters.FilterPassportDto;
import ru.nabokovsg.adminservice.dtos.filters.NewFilterPassportDto;
import ru.nabokovsg.adminservice.dtos.filters.ShortFilterPassportDto;
import ru.nabokovsg.adminservice.dtos.filters.UpdateFilterPassportDto;

import java.util.List;

public interface FilterPassportService {

    FilterPassportDto save(NewFilterPassportDto passportDto);

    FilterPassportDto update(UpdateFilterPassportDto passportDto);

    FilterPassportDto get(Long pasId);

    List<ShortFilterPassportDto> getAll(Long filterId, Long addressId);

    void delete(Long pasId);
}
