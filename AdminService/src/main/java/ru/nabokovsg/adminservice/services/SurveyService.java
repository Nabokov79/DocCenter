package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.surveys.NewSurveyDto;
import ru.nabokovsg.adminservice.dtos.surveys.SurveyDto;
import ru.nabokovsg.adminservice.dtos.surveys.UpdateSurveyDto;

public interface SurveyService {

    SurveyDto save(NewSurveyDto surveyDto);

    SurveyDto update(UpdateSurveyDto surveyDto);

    void delete(Long surId);
}
