package ru.nabokovsg.adminservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.divisions.DivisionDto;
import ru.nabokovsg.adminservice.dtos.divisions.NewDivisionDto;
import ru.nabokovsg.adminservice.dtos.divisions.UpdateDivisionDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.DivisionMapper;
import ru.nabokovsg.adminservice.models.Division;
import ru.nabokovsg.adminservice.repositoryes.DivisionRepository;
import ru.nabokovsg.adminservice.services.common.CommonService;

@Service
@RequiredArgsConstructor
public class DivisionServiceImpl implements DivisionService {

    private final DivisionRepository repository;
    private final CommonService commonService;
    private final DivisionMapper mapper;

    @Override
    public DivisionDto save(NewDivisionDto divisionDto) {
        Division division = commonService.setDivisionValue(mapper.mapToNewDivision(divisionDto),
                                                           mapper.mapToNewDivisionIds(divisionDto));
        if (repository.existsByLicenseAndBranch(division.getLicense(), divisionDto.getBranch())) {
            throw new BadRequestException(
                    String.format("division with licenseId=%s and branch=%s found", divisionDto.getLicenseId()
                                                                                  , divisionDto.getBranch()));
        }
        return mapper.mapToDivisionDto(repository.save(division));
    }

    @Override
    public DivisionDto update(UpdateDivisionDto divisionDto) {
        if (!repository.existsById(divisionDto.getId())) {
            throw new NotFoundException(
                    String.format("division with id=%s not found for update", divisionDto.getId()));
        }
        Division division = commonService.setDivisionValue(mapper.mapToUpdateDivision(divisionDto),
                mapper.mapToUpdateDivisionIds(divisionDto));
        return mapper.mapToDivisionDto(repository.save(division));
    }

    @Override
    public DivisionDto get(Long divId) {
        Division division = repository.findById(divId).orElseThrow(() -> new NotFoundException(
                                                     String.format("division with id=%s not found for update", divId)));
        return mapper.mapToDivisionDto(division);
    }
}