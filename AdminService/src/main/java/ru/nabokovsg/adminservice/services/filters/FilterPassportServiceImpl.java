package ru.nabokovsg.adminservice.services.filters;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.filters.*;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.models.Dimensions;
import ru.nabokovsg.adminservice.models.filters.Filter;
import ru.nabokovsg.adminservice.mappers.filters.FilterPassportMapper;
import ru.nabokovsg.adminservice.models.filters.FilterPassport;
import ru.nabokovsg.adminservice.models.filters.QFilterPassport;
import ru.nabokovsg.adminservice.repositoryes.DimensionsRepository;
import ru.nabokovsg.adminservice.repositoryes.filters.FilterPassportRepository;
import ru.nabokovsg.adminservice.repositoryes.filters.FilterRepository;
import ru.nabokovsg.adminservice.services.common.CommonService;
import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterPassportServiceImpl implements FilterPassportService {

    private final FilterPassportRepository repository;
    private final FilterRepository filterRepository;
    private final DimensionsRepository dimensionsRepository;
    private final FilterPassportMapper mapper;
    private final CommonService commonService;
    private final EntityManager entityManager;

    @Override
    public FilterPassportDto save(NewFilterPassportDto passportDto) {
        RequestIds requestIds = mapper.mapToNewRequestIdsDto(passportDto);
        FilterIdsDto ids = new FilterIdsDto(passportDto.getFilterId(), passportDto.getDimensionsId());
        FilterPassport passport =  setValues(mapper.mapToNewFilterPassport(passportDto), ids, requestIds);
        if (repository.existsByFilterAndAddress(passport.getFilter(), passport.getAddress())) {
            throw new BadRequestException(String.format("passport=%s found", passportDto));
        }
        return mapper.mapToFilterPassportDto(repository.save(passport));
    }

    @Override
    public FilterPassportDto update(UpdateFilterPassportDto passportDto) {
        if (!repository.existsById(passportDto.getId())) {
            throw new NotFoundException(String.format("passport with id=%s not found",passportDto.getId()));
        }
        RequestIds requestIds = mapper.mapToUpdateRequestIdsDto(passportDto);
        FilterIdsDto ids = new FilterIdsDto(passportDto.getFilterId(), passportDto.getDimensionsId());
        FilterPassport passport =  setValues(mapper.mapToUpdateFilterPassport(passportDto), ids, requestIds);
        return mapper.mapToFilterPassportDto(repository.save(passport));
    }

    @Override
    public FilterPassportDto get(Long pasId) {
        return  mapper.mapToFilterPassportDto(repository.findById(pasId)
                .orElseThrow(() -> new NotFoundException(String.format("passport with id=%s not found",pasId)))
        );
    }

    @Override
    public List<ShortFilterPassportDto> getAll(Long filterId, Long addressId) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (filterId != null) {
            booleanBuilder.and(QFilterPassport.filterPassport.filter.id.eq(filterId));
        }
        if (addressId != null) {
            booleanBuilder.and(QFilterPassport.filterPassport.address.id.eq(addressId));
        }
        QFilterPassport passports = QFilterPassport.filterPassport;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<FilterPassport> query = qf.from(passports)
                .select(passports)
                .where(booleanBuilder)
                .groupBy(passports.address);
        return mapper.mapToShortFilterPassport(query.fetch());
    }

    @Override
    public void delete(Long pasId) {
        if (repository.existsById(pasId)) {
            repository.deleteById(pasId);
        }
        throw new NotFoundException(String.format("passport with id=%s not found for delete", pasId));
    }

    private FilterPassport setValues(FilterPassport passportDto, FilterIdsDto ids, RequestIds requestIds) {
        CommonDto commonDto = commonService.getObjects(requestIds);
        FilterPassport passport = mapper.mapToFilterPassport(passportDto, commonDto);
        passport.setFilter(getFilter(ids.getFilterId()));
        passport.setDimensions(getDimension(ids.getDimensionsId()));
        return passport;
    }

    private Filter getFilter(Long id) {
        return filterRepository.findById(id)
                             .orElseThrow(() -> new NotFoundException(String.format("filter with id=%s not found",id)));
    }

    private Dimensions getDimension(Long id) {
        return dimensionsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("dimensions with id=%s not found",id)));
    }
}
