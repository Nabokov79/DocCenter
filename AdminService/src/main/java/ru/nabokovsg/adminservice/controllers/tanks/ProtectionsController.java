package ru.nabokovsg.adminservice.controllers.tanks;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.tanks.protections.NewProtectionsDto;
import ru.nabokovsg.adminservice.dtos.tanks.protections.ProtectionsDto;
import ru.nabokovsg.adminservice.dtos.tanks.protections.UpdateProtectionsDto;
import ru.nabokovsg.adminservice.services.tanks.ProtectionsService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/tanks/protections",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Антикоррозионная защита",
        description="API для работы с данными антикоррозионной защиты бака")
public class ProtectionsController {

    private final ProtectionsService service;

    @Operation(summary = "Добавление новых данных антикоррозионной защиты бака")
    @PostMapping
    public ResponseEntity<ProtectionsDto> save(
            @RequestBody @Parameter(description = "Антикоррозионная защита") NewProtectionsDto protectionsDto) {
        return ResponseEntity.ok().body(service.save(protectionsDto));
    }

    @Operation(summary = "Изменение данных антикоррозионной защиты бака")
    @PatchMapping
    public ResponseEntity<ProtectionsDto> update(
            @RequestBody @Parameter(description = "Антикоррозионная защита") UpdateProtectionsDto protectionsDto) {
        return ResponseEntity.ok().body(service.update(protectionsDto));
    }

    @Operation(summary = "Получение всех данных")
    @GetMapping
    public ResponseEntity<List<ProtectionsDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных антикоррозионной защиты")
    @DeleteMapping("/{proId}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long proId) {
        service.delete(proId);
        return ResponseEntity.ok("Данные удалены.");
    }
}
