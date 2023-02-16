package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.licenses.LicenseDto;
import ru.nabokovsg.adminservice.dtos.licenses.NewLicenseDto;
import ru.nabokovsg.adminservice.dtos.licenses.UpdateLicenseDto;
import ru.nabokovsg.adminservice.models.License;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LicenseMapper {

    License mapToNewLicense(NewLicenseDto licenseDto);

    LicenseDto mapToLicenseDto(License license);

    License mapToUpdateLicense(UpdateLicenseDto licenseDto);

    List<LicenseDto> mapToLicensesDto(List<License> licenses);
}
