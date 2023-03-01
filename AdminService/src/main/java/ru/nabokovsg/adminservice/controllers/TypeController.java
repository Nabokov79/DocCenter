package ru.nabokovsg.adminservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.types.NewTypeDto;
import ru.nabokovsg.adminservice.dtos.types.TypeDto;
import ru.nabokovsg.adminservice.dtos.types.UpdateTypeDto;
import ru.nabokovsg.adminservice.services.TypeService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/types",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Тип объекта",
        description="API для работы с данными типа объекта")
public class TypeController {

    private final TypeService service;

    @Operation(summary = "Добавление данных типа объекта")
    @PostMapping
    public ResponseEntity<TypeDto> save(@RequestBody @Parameter(description = "Тип объекта") NewTypeDto typeDto) {
        return ResponseEntity.ok().body(service.save(typeDto));
    }

    @Operation(summary = "Изменение данных типа объекта")
    @PatchMapping
    public ResponseEntity<TypeDto> update(@RequestBody @Parameter(description = "Тип объекта") UpdateTypeDto typeDto) {
        return ResponseEntity.ok().body(service.update(typeDto));
    }

    @Operation(summary = "Получение данных типа объекта")
    @GetMapping
    public ResponseEntity<List<TypeDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}
