package ru.nabokovsg.adminservice.mappers.users;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.users.CertificateDto;
import ru.nabokovsg.adminservice.dtos.users.NewCertificateDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateCertificateDto;
import ru.nabokovsg.adminservice.models.users.Certificate;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CertificateMapper {

    List<CertificateDto> mapToCertificatesDto(List<Certificate> certificates);

    Certificate mapToCertificate(NewCertificateDto newCertificateDto);

    Certificate mapToUpdateCertificate(UpdateCertificateDto updateCertificateDto);
}
