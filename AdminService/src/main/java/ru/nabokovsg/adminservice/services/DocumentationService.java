package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.documentation.DocumentationDto;
import ru.nabokovsg.adminservice.dtos.documentation.NewDocumentationDto;
import ru.nabokovsg.adminservice.dtos.documentation.UpdateDocumentationDto;
import java.util.List;

public interface DocumentationService {

    DocumentationDto save(NewDocumentationDto documentationDto, String typeObject);

    DocumentationDto update(UpdateDocumentationDto documentationDto, String typeObject);

    List<DocumentationDto> getAll(String typeObject, String typeDocument, String numberDocument);

    String delete(Long docId);
}
