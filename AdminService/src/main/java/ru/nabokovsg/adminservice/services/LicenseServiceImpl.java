package ru.nabokovsg.adminservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.licenses.LicenseDto;
import ru.nabokovsg.adminservice.dtos.licenses.NewLicenseDto;
import ru.nabokovsg.adminservice.dtos.licenses.UpdateLicenseDto;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.LicenseMapper;
import ru.nabokovsg.adminservice.models.License;
import ru.nabokovsg.adminservice.repositoryes.LicenseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository repository;
    private final LicenseMapper mapper;

    @Override
    public LicenseDto save(NewLicenseDto licenseDto) {
        if (repository.existsByDate(licenseDto.getDate())) {
            throw new NotFoundException(String.format("license with date=%s found", licenseDto.getDate()));
        }
        License license = mapper.mapToNewLicense(licenseDto);
        return mapper.mapToLicenseDto(repository.save(license));
    }

    @Override
    public LicenseDto update(UpdateLicenseDto licenseDto) {
        if (!repository.existsById(licenseDto.getId())) {
            throw new NotFoundException(String.format("license with id=%s not found for update", licenseDto.getId()));
        }
        License license = mapper.mapToUpdateLicense(licenseDto);
        return mapper.mapToLicenseDto(repository.save(license));
    }

    @Override
    public LicenseDto get(Long lisId) {
        return mapper.mapToLicenseDto(
                repository.findById(lisId).orElseThrow(() -> new NotFoundException(
                                                                String.format("license with id=%s not found", lisId))));
    }

    @Override
    public List<LicenseDto> getAll() {
        return mapper.mapToLicensesDto(repository.findAll());
    }
}
