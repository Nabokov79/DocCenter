package ru.nabokovsg.adminservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.divisions.DivisionDto;
import ru.nabokovsg.adminservice.dtos.divisions.NewDivisionDto;
import ru.nabokovsg.adminservice.dtos.divisions.UpdateDivisionDto;
import ru.nabokovsg.adminservice.services.DivisionService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(
        value = "/admin/divisions",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Подразделение",
        description="API для работы с данными подразделения")
public class DivisionController {

    private final DivisionService service;

    @Operation(summary = "Добавление данных лаборатории")
    @PostMapping
    public ResponseEntity<DivisionDto> save(
            @RequestBody @Parameter(description = "Подразделение") NewDivisionDto divisionDto) {
        return ResponseEntity.ok().body(service.save(divisionDto));
    }

    @Operation(summary = "Изменение данных лаборатории")
    @PatchMapping
    public ResponseEntity<DivisionDto> update(
            @RequestBody @Parameter(description = "Подразделение") UpdateDivisionDto divisionDto) {
        return ResponseEntity.ok().body(service.update(divisionDto));
    }

    @Operation(summary = "Получение данных падразделения")
    @GetMapping("/{divId}")
    public ResponseEntity<DivisionDto> get(
            @PathVariable @NotNull @Positive @Parameter(description = "Индентификатор лаборатории") Long divId) {
        return ResponseEntity.ok().body(service.get(divId));
    }
}
