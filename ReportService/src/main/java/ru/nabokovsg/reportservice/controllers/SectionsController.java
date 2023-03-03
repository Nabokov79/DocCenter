package ru.nabokovsg.reportservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.reportservice.dtos.*;
import ru.nabokovsg.reportservice.services.SectionsService;

@RestController
@RequestMapping(
        value = "/report/sections",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Раздел отчета",
        description="API для работы с раздел отчета")
public class SectionsController {

    private final SectionsService service;

    @Operation(summary = "Добавление нового раздела отчета")
    @PostMapping
    public ResponseEntity<SectionDto> save(
            @RequestBody @Validated @Parameter(description = "Раздел отчета") NewSectionDto sectionDto) {
        return ResponseEntity.ok().body(service.save(sectionDto));
    }

    @Operation(summary = "Изменение данных раздела отчета")
    @PatchMapping
    public ResponseEntity<SectionDto> update(
            @RequestBody @Validated @Parameter(description = "Раздел отчета") UpdateSectionDto sectionDto) {
        return ResponseEntity.ok().body(service.update(sectionDto));
    }

    @Operation(summary = "Получение раздела отчета")
    @GetMapping("/{secId}")
    public ResponseEntity<SectionDto> get(@PathVariable Long secId) {
        return ResponseEntity.ok().body(service.get(secId));
    }
}
