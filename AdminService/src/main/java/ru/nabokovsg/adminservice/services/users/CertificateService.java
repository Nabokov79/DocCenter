package ru.nabokovsg.adminservice.services.users;

import ru.nabokovsg.adminservice.dtos.users.CertificateDto;
import ru.nabokovsg.adminservice.dtos.users.NewCertificateDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateCertificateDto;

import java.time.LocalDate;
import java.util.List;

public interface CertificateService {

    List<CertificateDto> save(List<NewCertificateDto> newCertificates);

    List<CertificateDto> update(List<UpdateCertificateDto> updateCertificates);

    List<CertificateDto> getAll(Long userId, LocalDate date);

    void delete(Long cerId);
}
