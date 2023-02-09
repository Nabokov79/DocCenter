package ru.nabokovsg.adminservice.controllers.piplines;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.NewPurposePipelineDto;
import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.PurposePipelineDto;
import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.UpdatePurposePipelineDto;
import ru.nabokovsg.adminservice.services.pipelines.PurposePipelineService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/pipeline/purpose",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Названия назначения трубопровода",
        description="API для работы с данными о названии назначения трубопровода")
public class PurposePipelineController {

    private final PurposePipelineService service;

    @Operation(summary = "Добавление данных названия назначения трубопровода")
    @PostMapping
    public ResponseEntity<PurposePipelineDto> save(
            @RequestBody
            @Parameter(description = "Название назначения трубопровода") NewPurposePipelineDto purposePipeDto) {
        return ResponseEntity.ok().body(service.save(purposePipeDto));
    }

    @Operation(summary = "Изменение данных названия назначения трубопровода")
    @PatchMapping
    public ResponseEntity<PurposePipelineDto> update(
            @RequestBody
            @Parameter(description = "Название назначения трубопровода") UpdatePurposePipelineDto purposePipeDto) {
        return ResponseEntity.ok().body(service.update(purposePipeDto));
    }

    @Operation(summary = "Получение данных названий назначений трубопроводов")
    @GetMapping
    public ResponseEntity<List<PurposePipelineDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление названия назначения трубопровода")
    @DeleteMapping("/{purId}")
    public ResponseEntity<String> delete(
            @PathVariable @Parameter(description = "Индентификатор названия назначения трубопровода") Long purId) {
        return ResponseEntity.ok(service.delete(purId) + " - удален");
    }
}
