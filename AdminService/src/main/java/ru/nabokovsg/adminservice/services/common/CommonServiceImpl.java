package ru.nabokovsg.adminservice.services.common;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.models.*;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.documentation.Documentation;
import ru.nabokovsg.adminservice.repositoryes.*;
import ru.nabokovsg.adminservice.repositoryes.addresses.AddressRepository;

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

    @Override
    public CommonDto getObjects(RequestIds requestIds) {
        CommonDto commonDto = new CommonDto();
        if (requestIds.getAuthorId() != null) {
            commonDto.setAuthor(getAuthor(requestIds.getAuthorId()));
        }
        if (requestIds.getManufacturerId() != null) {
            commonDto.setManufacturer(getManufacturer(requestIds.getManufacturerId()));
        }
        if (requestIds.getMountingId() != null) {
            commonDto.setMounting(getMounting(requestIds.getMountingId()));
        }
        if (requestIds.getAddressId() != null) {
            commonDto.setAddress(getAddress(requestIds.getAddressId()));
        }
        if (requestIds.getSurveysId() != null) {
            commonDto.setSurveys(getSurveys(requestIds.getSurveysId()));
        }
        if (requestIds.getRepairsId() != null) {
            commonDto.setRepairs(getRepairs(requestIds.getRepairsId()));
        }
        if (requestIds.getDocumentationId() != null) {
            commonDto.setDocumentation(getDocumentations(requestIds.getDocumentationId()));
        }
        return commonDto;
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
        Map<Long, Survey> surveys = surveyRepository.findAllById(ids)
                                                   .stream().collect(Collectors.toMap(Survey::getId, survey -> survey));
        if (surveys.size() != ids.size() || surveys.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(surveys.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("survey with id= %s not found", ids));
        }
        return new ArrayList<>(surveys.values());
    }

    private List<Repair> getRepairs(List<Long> ids) {
        Map<Long, Repair> repairs = repairRepository.findAllById(ids)
                                                   .stream().collect(Collectors.toMap(Repair::getId, repair -> repair));
        if (repairs.size() != ids.size() || repairs.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(repairs.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("repairs with id= %s not found", ids));
        }
        return new ArrayList<>(repairs.values());

    }

    private List<Documentation> getDocumentations(List<Long> ids) {
        Map<Long, Documentation> documentations = documentationRepository.findAllById(ids)
                                                  .stream().collect(Collectors.toMap(Documentation::getId, doc -> doc));
        if (documentations.size() != ids.size() || documentations.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(documentations.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("documentations with id= %s not found", ids));
        }
        return new ArrayList<>(documentations.values());
    }
}
