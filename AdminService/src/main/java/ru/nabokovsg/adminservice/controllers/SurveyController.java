package ru.nabokovsg.adminservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.surveys.NewSurveyDto;
import ru.nabokovsg.adminservice.dtos.surveys.SurveyDto;
import ru.nabokovsg.adminservice.dtos.surveys.UpdateSurveyDto;
import ru.nabokovsg.adminservice.services.SurveyService;

@RestController
@RequestMapping(
        value = "/admin/surveys",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Обследования",
        description="API для работы с данными о проведенных обследованиях")
public class SurveyController {

    private final SurveyService service;

    @Operation(summary = "Добавление информации о новом обследовании")
    @PostMapping
    public ResponseEntity<SurveyDto> save(
                                        @RequestBody @Parameter(description = "Обследование") NewSurveyDto surveyDto) {
        return ResponseEntity.ok().body(service.save(surveyDto));
    }

    @Operation(summary = "Изменение информации об обследовании")
    @PatchMapping
    public ResponseEntity<SurveyDto> update(
            @RequestBody @Parameter(description = "Обследование") UpdateSurveyDto surveyDto) {
        return ResponseEntity.ok().body(service.update(surveyDto));
    }

    @Operation(summary = "Удаление информации о проведенном обследовании")
    @DeleteMapping("/{surId}")
    public ResponseEntity<String> delete(
                                    @PathVariable @Parameter(description = "Индентификатор обследования") Long surId) {
        service.delete(surId);
        return ResponseEntity.ok("Сведения об обследовании удалены.");
    }
}
