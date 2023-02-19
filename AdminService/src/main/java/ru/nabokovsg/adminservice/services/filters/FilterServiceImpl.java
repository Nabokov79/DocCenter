package ru.nabokovsg.adminservice.services.filters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.models.filters.Filter;
import ru.nabokovsg.adminservice.dtos.filters.FilterDto;
import ru.nabokovsg.adminservice.dtos.filters.NewFilterDto;
import ru.nabokovsg.adminservice.dtos.filters.UpdateFilterDto;
import ru.nabokovsg.adminservice.mappers.filters.FilterMapper;
import ru.nabokovsg.adminservice.repositoryes.filters.FilterRepository;
import ru.nabokovsg.adminservice.services.common.CommonService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final FilterRepository repository;
    private final FilterMapper mapper;
    private final CommonService commonService;
    @Override
    public FilterDto save(NewFilterDto filterDto) {
        Filter filter = setLetterCase(mapper.mapToNewFilter(filterDto));
        filter.setType(commonService.getType(filterDto.getTypeId()));
        if (repository.existsByTypeAndModel(filter.getType(), filter.getModel())) {
            throw new BadRequestException(String.format("filter=%s found", filterDto));
        }
        return mapper.mapToFilterDto(repository.save(filter));
    }

    @Override
    public FilterDto update(UpdateFilterDto filterDto) {
        if (!repository.existsById(filterDto.getId())) {
            throw new NotFoundException(String.format("filter with id=%s not found for update", filterDto.getId()));
        }
        Filter filter = setLetterCase(mapper.mapToUpdateFilter(filterDto));
        filter.setType(commonService.getType(filterDto.getTypeId()));
        return mapper.mapToFilterDto(repository.save(filter));
    }

    @Override
    public List<FilterDto> getAll() {
        return mapper.mapToFiltersDto(repository.findAll());
    }

    @Override
    public void delete(Long filId) {
        if (repository.existsById(filId)) {
            repository.deleteById(filId);
        }
        throw new NotFoundException(String.format("filter with id=%s not found for delete", filId));
    }

    private Filter setLetterCase(Filter filter) {
        if (!filter.getModel().isEmpty()) {
            filter.setModel(filter.getModel().toUpperCase());
        }
        return filter;
    }
}
