package ru.nabokovsg.reportservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.reportservice.dtos.NewReportPatternDto;
import ru.nabokovsg.reportservice.dtos.ReportPatternDto;
import ru.nabokovsg.reportservice.dtos.UpdateReportPatternDto;
import ru.nabokovsg.reportservice.services.ReportPatternService;

@RestController
@RequestMapping(
        value = "/report/pattern",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон отчета",
     description="API для работы с шаблона отчета")

public class ReportPatternController {

    private final ReportPatternService service;

    @Operation(summary = "Добавление нового шаблона")
    @PostMapping
    public ResponseEntity<ReportPatternDto> save(
            @RequestBody @Validated @Parameter(description = "Шаблон отчета") NewReportPatternDto patternDto) {
        return ResponseEntity.ok().body(service.save(patternDto));
    }

    @Operation(summary = "Изменение данных шаблона")
    @PatchMapping
    public ResponseEntity<ReportPatternDto> update(
            @RequestBody @Validated @Parameter(description = "Шаблон отчета") UpdateReportPatternDto patternDto) {
        return ResponseEntity.ok().body(service.update(patternDto));
    }

    @Operation(summary = "Получение шаблона отчета")
    @GetMapping("/{patId}")
    public ResponseEntity<ReportPatternDto> get(@PathVariable Long patId) {
        return ResponseEntity.ok().body(service.get(patId));
    }
}
