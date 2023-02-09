package ru.nabokovsg.adminservice.mappers.filters;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.filters.FilterDto;
import ru.nabokovsg.adminservice.dtos.filters.NewFilterDto;
import ru.nabokovsg.adminservice.dtos.filters.UpdateFilterDto;
import ru.nabokovsg.adminservice.models.filters.Filter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FilterMapper {

    Filter mapToNewFilter(NewFilterDto filterDto);

    FilterDto mapToFilterDto(Filter filter);

    Filter mapToUpdateFilter(UpdateFilterDto filterDto);

    List<FilterDto> mapToFiltersDto(List<Filter> filters);
}
