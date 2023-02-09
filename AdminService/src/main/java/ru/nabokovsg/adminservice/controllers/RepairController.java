package ru.nabokovsg.adminservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.repairs.NewRepairDto;
import ru.nabokovsg.adminservice.dtos.repairs.RepairDto;
import ru.nabokovsg.adminservice.dtos.repairs.UpdateRepairDto;
import ru.nabokovsg.adminservice.services.RepairService;

@RestController
@RequestMapping(
        value = "/admin/repairs",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Ремонты",
        description="API для работы с данными о проведенных ремонтах")
public class RepairController {

    private final RepairService service;

    @Operation(summary = "Добавление информации о новом ремонте")
    @PostMapping
    public ResponseEntity<RepairDto> save(@RequestBody @Parameter(description = "Ремонт") NewRepairDto repairDto) {
        return ResponseEntity.ok().body(service.save(repairDto));
    }

    @Operation(summary = "Изменение информации о ремонте")
    @PatchMapping
    public ResponseEntity<RepairDto> update(@RequestBody @Parameter(description = "Ремонт") UpdateRepairDto repairDto) {
        return ResponseEntity.ok().body(service.update(repairDto));
    }

    @Operation(summary = "Удаление информации о проведенном ремонте")
    @DeleteMapping("/{repId}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор ремонта") Long repId) {
        service.delete(repId);
        return ResponseEntity.ok("Сведения об ремонте удалены.");
    }
}
