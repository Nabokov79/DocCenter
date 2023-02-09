package ru.nabokovsg.adminservice.services.filters;

import ru.nabokovsg.adminservice.dtos.filters.FilterDto;
import ru.nabokovsg.adminservice.dtos.filters.NewFilterDto;
import ru.nabokovsg.adminservice.dtos.filters.UpdateFilterDto;

import java.util.List;

public interface FilterService {

    FilterDto save(NewFilterDto filterDto);

    FilterDto update(UpdateFilterDto filterDto);

   List<FilterDto> getAll();

    void delete(Long filId);
}
