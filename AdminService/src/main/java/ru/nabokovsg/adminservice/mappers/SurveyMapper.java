package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.surveys.NewSurveyDto;
import ru.nabokovsg.adminservice.dtos.surveys.SurveyDto;
import ru.nabokovsg.adminservice.dtos.surveys.UpdateSurveyDto;
import ru.nabokovsg.adminservice.models.Survey;

@Mapper(componentModel = "spring")
public interface SurveyMapper {

    Survey mapToNewSurvey(NewSurveyDto surveyDto);

    SurveyDto mapToSurveyDto(Survey survey);

    Survey mapToUpdateSurvey(UpdateSurveyDto surveyDto);
}
