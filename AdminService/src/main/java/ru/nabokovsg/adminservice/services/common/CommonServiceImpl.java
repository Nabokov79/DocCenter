package ru.nabokovsg.adminservice.services.common;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.Type;
import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.dtos.DivisionIds;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.users.MeasuringToolIds;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.models.*;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.documentation.Documentation;
import ru.nabokovsg.adminservice.models.users.ControlType;
import ru.nabokovsg.adminservice.models.users.MeasuringTool;
import ru.nabokovsg.adminservice.models.users.Owner;
import ru.nabokovsg.adminservice.models.users.User;
import ru.nabokovsg.adminservice.repositoryes.*;
import ru.nabokovsg.adminservice.repositoryes.addresses.AddressRepository;
import ru.nabokovsg.adminservice.repositoryes.addresses.CityRepository;
import ru.nabokovsg.adminservice.repositoryes.users.ControlTypeRepository;
import ru.nabokovsg.adminservice.repositoryes.users.OwnerRepository;
import ru.nabokovsg.adminservice.repositoryes.users.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final AuthorRepository authorRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final MountingRepository mountingRepository;
    private final AddressRepository addressRepository;
    private final SurveyRepository surveyRepository;
    private final RepairRepository repairRepository;
    private final DocumentationRepository documentationRepository;
    private final ControlTypeRepository controlTypeRepository;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final OwnerRepository ownerRepository;
    private final CityRepository cityRepository;
    private final LicenseRepository licenseRepository;
    private final TypeRepository typeRepository;

    @Override
    public CommonDto getObjects(RequestIds requestIds) {
        CommonDto commonDto = new CommonDto();
        if (requestIds.getAuthorId() != null && requestIds.getAuthorId() > 0) {
            commonDto.setAuthor(getAuthor(requestIds.getAuthorId()));
        }
        if (requestIds.getManufacturerId() != null && requestIds.getManufacturerId() > 0) {
            commonDto.setManufacturer(getManufacturer(requestIds.getManufacturerId()));
        }
        if (requestIds.getMountingId() != null && requestIds.getMountingId() > 0) {
            commonDto.setMounting(getMounting(requestIds.getMountingId()));
        }
        if (requestIds.getAddressId() != null && requestIds.getAddressId() > 0) {
            commonDto.setAddress(getAddress(requestIds.getAddressId()));
        }
        if (requestIds.getSurveysId() != null && !requestIds.getSurveysId().isEmpty()) {
            commonDto.setSurveys(getSurveys(requestIds.getSurveysId()));
        }
        if (requestIds.getRepairsId() != null && !requestIds.getRepairsId().isEmpty()) {
            commonDto.setRepairs(getRepairs(requestIds.getRepairsId()));
        }
        if (requestIds.getDocumentationId() != null && !requestIds.getDocumentationId().isEmpty()) {
            commonDto.setDocumentation(getDocumentations(requestIds.getDocumentationId()));
        }
        return commonDto;
    }

    @Override
    public MeasuringTool setMeasuringToolValue(MeasuringTool measuringTool, MeasuringToolIds ids) {
        measuringTool.setType(getControlType(ids.getTypeId()));
        measuringTool.setOrganization(getOrganization(ids.getOrganizationId()));
        measuringTool.setUser(getUser(ids.getUserId()));
        measuringTool.setManufacturer(getManufacturer(ids.getManufacturerId()));
        measuringTool.setOwner(getOwner(ids.getOwnerId()));
        return measuringTool;
    }

    @Override
    public Division setDivisionValue(Division division, DivisionIds ids) {
        division.setCity(getCity(ids.getCityId()));
        division.setOrganization(getOrganization(ids.getOrganizationId()));
        division.setLicense(getLicense(ids.getLicenseId()));
        return division;
    }

    @Override
    public Type getType(Long typId) {
        return typeRepository.findById(typId)
                .orElseThrow(() -> new NotFoundException(String.format("type with id=%s not found", typId)));
    }

    private City getCity(Long citId) {
        return cityRepository.findById(citId)
                .orElseThrow(() -> new NotFoundException(String.format("city with id=%s not found", citId)));
    }

    private License getLicense(Long licId) {
        return licenseRepository.findById(licId)
                .orElseThrow(() -> new NotFoundException(String.format("license with id=%s not found", licId)));
    }

    private ControlType getControlType(Long typId) {
        return controlTypeRepository.findById(typId)
                .orElseThrow(() -> new NotFoundException(String.format("control type with id=%s not found", typId)));
    }

    private Organization getOrganization(Long orgId) {
        return organizationRepository.findById(orgId)
                .orElseThrow(() -> new NotFoundException(String.format("organization with id=%s not found", orgId)));
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("user with id=%s not found", userId)));
    }
    private Owner getOwner(Long ownerId) {
       return ownerRepository.findById(ownerId)
                .orElseThrow(() -> new NotFoundException(String.format("owner with id=%s not found", ownerId)));
    }

    private Author getAuthor(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("author with id=%s not found", id)));
    }

    private Manufacturer getManufacturer(Long id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("manufacturer with id=%s not found", id)));
    }

    private Mounting getMounting(Long id) {
        return mountingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("mounting with id=%s not found", id)));
    }

   private Address getAddress(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("address with id=%s not found", id)));
    }

   private List<Survey> getSurveys(List<Long> ids) {
        Map<Long, Survey> surveys = surveyRepository.findAllById(filterIds(ids))
                                                   .stream().collect(Collectors.toMap(Survey::getId, survey -> survey));
        if (surveys.size() != ids.size() || surveys.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(surveys.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("survey with id= %s not found", ids));
        }
        return new ArrayList<>(surveys.values());
    }

    private List<Repair> getRepairs(List<Long> ids) {
        Map<Long, Repair> repairs = repairRepository.findAllById(filterIds((ids)))
                                                   .stream().collect(Collectors.toMap(Repair::getId, repair -> repair));
        if (repairs.size() != ids.size() || repairs.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(repairs.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("repairs with id= %s not found", ids));
        }
        return new ArrayList<>(repairs.values());

    }

    private List<Documentation> getDocumentations(List<Long> ids) {
        Map<Long, Documentation> documentations = documentationRepository.findAllById(filterIds(ids))
                                                  .stream().collect(Collectors.toMap(Documentation::getId, doc -> doc));
        if (documentations.size() != ids.size() || documentations.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(documentations.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("documentations with id= %s not found", ids));
        }
        return new ArrayList<>(documentations.values());
    }

    private List<Long> filterIds(List<Long> ids) {
        return ids.stream().filter(s -> s > 0).toList();
    }
}
