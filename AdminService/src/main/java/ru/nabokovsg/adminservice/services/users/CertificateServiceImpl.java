package ru.nabokovsg.adminservice.services.users;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.users.CertificateDto;
import ru.nabokovsg.adminservice.dtos.users.NewCertificateDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateCertificateDto;
import ru.nabokovsg.adminservice.models.Organization;
import ru.nabokovsg.adminservice.models.users.*;
import ru.nabokovsg.adminservice.repositoryes.users.ControlTypeRepository;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.users.CertificateMapper;
import ru.nabokovsg.adminservice.repositoryes.users.CertificateRepository;
import ru.nabokovsg.adminservice.repositoryes.OrganizationRepository;
import ru.nabokovsg.adminservice.repositoryes.users.UserRepository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository repository;
    private final OrganizationRepository organizationRepository;
    private final ControlTypeRepository controlTypeRepository;
    private final UserRepository userRepository;
    private final CertificateMapper mapper;
    private final EntityManager entityManager;

    @Override
    public List<CertificateDto> save(List<NewCertificateDto> newCertificates) {
        if (newCertificates.isEmpty()) {
            throw new NotFoundException("new certificates not found for save");
        }
        List<Certificate> certificatesDb = setCertificatesValue(newCertificates, null);
        return mapper.mapToCertificatesDto(repository.saveAll(certificatesDb));
    }

    @Override
    public List<CertificateDto> update(List<UpdateCertificateDto> updateCertificates) {
        if (updateCertificates.isEmpty()) {
            throw new NotFoundException("certificates not found for update");
        }
        List<Certificate> certificatesDb = setCertificatesValue(null, updateCertificates);
        return mapper.mapToCertificatesDto(repository.saveAll(certificatesDb));
    }

    @Override
    public List<CertificateDto> getAll(Long userId, LocalDate date) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (userId != null) {
            booleanBuilder.and(QCertificate.certificate.user.id.eq(userId));
        }
        if (date != null) {
            booleanBuilder.and(QCertificate.certificate.end.before(date));
        }
        QCertificate certificates = QCertificate.certificate;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<Certificate> query = qf.from(certificates)
                .select(certificates)
                .where(booleanBuilder);
        return mapper.mapToCertificatesDto(query.fetch());
    }

    @Override
    public void delete(Long cerId) {
        if (repository.existsById(cerId)) {
            repository.deleteById(cerId);
            return;
        }
        throw new NotFoundException(String.format("certificate with id = %s not found for delete", cerId));
    }

    public List<Certificate> setCertificatesValue(List<NewCertificateDto> newCertificates,
                                                  List<UpdateCertificateDto> updateCertificates) {
        List<Certificate> certificates = new ArrayList<>();
        Map<Long, ControlType> typeControls = controlTypeRepository.findAll().stream()
                                             .collect(Collectors.toMap(ControlType::getId, controlType -> controlType));
        Map<Long, Organization> organizations = organizationRepository.findAll().stream()
                                          .collect(Collectors.toMap(Organization::getId, organization -> organization));
        Map<Long, User> users = userRepository.findAll().stream().collect(Collectors.toMap(User::getId, user -> user));
        if (newCertificates != null) {
            for (NewCertificateDto certificateDto : newCertificates) {
                Certificate certificate = mapper.mapToCertificate(certificateDto);
                certificate.setType(typeControls.get(certificateDto.getTypeId()));
                certificate.setOrganization(organizations.get(certificateDto.getOrganizationId()));
                certificate.setUser(users.get(certificateDto.getUserId()));
                certificates.add(certificate);
            }
        }
        if (updateCertificates != null) {
            for (UpdateCertificateDto certificateDto : updateCertificates) {
                Certificate certificate = mapper.mapToUpdateCertificate(certificateDto);
                certificate.setType(typeControls.get(certificateDto.getTypeId()));
                certificate.setOrganization(organizations.get(certificateDto.getOrganizationId()));
                certificate.setUser(users.get(certificateDto.getUserId()));
                certificates.add(certificate);
            }
        }
        return certificates;
    }
}
