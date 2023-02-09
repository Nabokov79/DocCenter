package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.documentation.DocumentationDto;
import ru.nabokovsg.adminservice.dtos.documentation.NewDocumentationDto;
import ru.nabokovsg.adminservice.dtos.documentation.UpdateDocumentationDto;
import ru.nabokovsg.adminservice.models.documentation.Documentation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentationMapper {


    Documentation mapToNewDocumentation(NewDocumentationDto documentationDto);

    DocumentationDto mapToDocumentationDto(Documentation documentation);

    Documentation mapToUpdateDocumentation(UpdateDocumentationDto documentationDto);

    List<DocumentationDto> mapToDocumentationsDto(List<Documentation> documentations);
}
