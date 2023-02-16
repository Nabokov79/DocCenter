package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.licenses.LicenseDto;
import ru.nabokovsg.adminservice.dtos.licenses.NewLicenseDto;
import ru.nabokovsg.adminservice.dtos.licenses.UpdateLicenseDto;

import java.util.List;

public interface LicenseService {

    LicenseDto save(NewLicenseDto licenseDto);

    LicenseDto update(UpdateLicenseDto licenseDto);

    LicenseDto get(Long lisId);

    List<LicenseDto> getAll();
}
