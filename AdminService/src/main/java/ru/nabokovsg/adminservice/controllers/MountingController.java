package ru.nabokovsg.adminservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.mounting.MountingDto;
import ru.nabokovsg.adminservice.dtos.mounting.NewMountingDto;
import ru.nabokovsg.adminservice.dtos.mounting.UpdateMountingDto;
import ru.nabokovsg.adminservice.services.MountingService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/mountings",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Монтажная организация",
     description="API для работы с данными о монтажной организации")
public class MountingController {

    private final MountingService service;

    @Operation(summary = "Добавление данных новой монтажной организации")
    @PostMapping
    public ResponseEntity<MountingDto> save(@RequestBody
                                         @Parameter(description = "Монтажная организация") NewMountingDto mountingDto) {
        return ResponseEntity.ok().body(service.save(mountingDto));
    }

    @Operation(summary = "Изменение данных монтажной организации")
    @PatchMapping
    public ResponseEntity<MountingDto> update(@RequestBody
                                      @Parameter(description = "Монтажная организация") UpdateMountingDto mountingDto) {
        return ResponseEntity.ok().body(service.update(mountingDto));
    }

    @Operation(summary = "Получение данных монтажных организаций")
    @GetMapping
    public ResponseEntity<List<MountingDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных монтажной организации")
    @DeleteMapping("/{mouId}")
    public ResponseEntity<String> delete(@PathVariable
                                         @Parameter(description = "Индентификатор монтажной организации") Long mouId) {
        return ResponseEntity.ok(service.delete(mouId) + " - удален.");
    }
}
