package ru.nabokovsg.adminservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.documentation.DocumentationDto;
import ru.nabokovsg.adminservice.dtos.documentation.NewDocumentationDto;
import ru.nabokovsg.adminservice.dtos.documentation.UpdateDocumentationDto;
import ru.nabokovsg.adminservice.services.DocumentationService;
import java.util.List;

@RequestMapping(
        value = "/admin/documentations",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Документация",
     description="API для работы с данными документации")
public class DocumentationController {

    private final DocumentationService service;

    @Operation(summary = "Добавление данных нового документа")
    @PostMapping
    public ResponseEntity<DocumentationDto> save(
                                 @RequestBody @Parameter(description = "Документ") NewDocumentationDto documentationDto,
                                 @RequestParam(value = "typeObject", required = false)
                                 @Parameter(description = "Тип объекта") String typeObject) {
        return ResponseEntity.ok().body(service.save(documentationDto,typeObject));
    }

    @Operation(summary = "Изменение данных документа")
    @PatchMapping
    public ResponseEntity<DocumentationDto> update(
                              @RequestBody @Parameter(description = "Документ") UpdateDocumentationDto documentationDto,
                              @RequestParam(value = "typeObject", required = false)
                              @Parameter(description = "Тип объекта") String typeObject) {
        return ResponseEntity.ok().body(service.update(documentationDto, typeObject));
    }

    @GetMapping
    public ResponseEntity<List<DocumentationDto>> getAll(
            @RequestParam(value = "typeObject", required = false)
            @Parameter(description = "Тип объекта") String typeObject,
            @RequestParam(value = "typeDocument", required = false)
            @Parameter(description = "Тип документа") String typeDocument,
            @RequestParam(required = false)
            @Parameter(description = "номер документа") String numberDocument) {
        return ResponseEntity.ok().body(service.getAll(typeObject,typeDocument, numberDocument));
    }

    @DeleteMapping("/{docId}")
    public ResponseEntity<String> delete(@PathVariable
                                         @Parameter(description = "Индентификатор документа") Long docId) {
        return ResponseEntity.ok("Документ " + service.delete(docId) + " удален.");
    }
}
