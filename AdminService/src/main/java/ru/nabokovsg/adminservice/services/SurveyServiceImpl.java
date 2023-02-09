package ru.nabokovsg.adminservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.surveys.NewSurveyDto;
import ru.nabokovsg.adminservice.dtos.surveys.SurveyDto;
import ru.nabokovsg.adminservice.dtos.surveys.UpdateSurveyDto;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.SurveyMapper;
import ru.nabokovsg.adminservice.models.Survey;
import ru.nabokovsg.adminservice.models.Organization;
import ru.nabokovsg.adminservice.repositoryes.OrganizationRepository;
import ru.nabokovsg.adminservice.repositoryes.SurveyRepository;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository repository;
    private final OrganizationRepository organizationRepository;
    private final SurveyMapper mapper;

    @Override
    public SurveyDto save(NewSurveyDto surveyDto) {
        Survey survey = mapper.mapToNewSurvey(surveyDto);
        survey.setOrganization(getOrganization(surveyDto.getOrganizationId()));
        return mapper.mapToSurveyDto(repository.save(survey));
    }

    @Override
    public SurveyDto update(UpdateSurveyDto surveyDto) {
        if (repository.existsById(surveyDto.getId())) {
            throw new NotFoundException(String.format("survey with id=%s not found for update", surveyDto.getId()));
        }
        Survey survey = mapper.mapToUpdateSurvey(surveyDto);
        survey.setOrganization(getOrganization(surveyDto.getOrganizationId()));
        return mapper.mapToSurveyDto(repository.save(survey));
    }

    @Override
    public void delete(Long surId) {
        if (repository.existsById(surId)) {
            repository.deleteById(surId);
        }
        throw new NotFoundException(String.format("survey with id=%s not found for delete", surId));
    }

    private Organization getOrganization(Long orgId) {
        return organizationRepository.findById(orgId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("organization with id=%s not found.", orgId))
                );
    }
}
