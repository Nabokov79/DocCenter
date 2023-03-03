package ru.nabokovsg.reportservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.reportservice.dtos.NewSectionDto;
import ru.nabokovsg.reportservice.dtos.SectionDto;
import ru.nabokovsg.reportservice.dtos.UpdateSectionDto;
import ru.nabokovsg.reportservice.models.Sections;


@Mapper(componentModel = "spring")
public interface SectionsMapper {

    Sections mapToSections(NewSectionDto sectionsDto);

    SectionDto mapToSectionsDto(Sections sections);

    Sections maoToUpdateSections(UpdateSectionDto sectionsDto);
}
