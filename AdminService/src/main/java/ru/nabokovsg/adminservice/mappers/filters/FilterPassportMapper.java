package ru.nabokovsg.adminservice.mappers.filters;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.filters.FilterPassportDto;
import ru.nabokovsg.adminservice.dtos.filters.NewFilterPassportDto;
import ru.nabokovsg.adminservice.dtos.filters.ShortFilterPassportDto;
import ru.nabokovsg.adminservice.dtos.filters.UpdateFilterPassportDto;
import ru.nabokovsg.adminservice.models.filters.FilterPassport;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FilterPassportMapper {

    FilterPassport mapToNewFilterPassport(NewFilterPassportDto passportDto);

    FilterPassportDto mapToFilterPassportDto(FilterPassport passport);

    FilterPassport mapToUpdateFilterPassport(UpdateFilterPassportDto passportDto);

    List<ShortFilterPassportDto> mapToShortFilterPassport(List<FilterPassport> passports);

    RequestIds mapToNewRequestIdsDto(NewFilterPassportDto passportDto);

    RequestIds mapToUpdateRequestIdsDto(UpdateFilterPassportDto passportDto);

    FilterPassport mapToFilterPassport(@MappingTarget FilterPassport passport, CommonDto commonDto);
}
