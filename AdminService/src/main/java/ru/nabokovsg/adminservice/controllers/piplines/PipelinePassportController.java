package ru.nabokovsg.adminservice.controllers.piplines;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.pipelines.NewPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.PipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.ShortPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.UpdatePipelinePassportDto;
import ru.nabokovsg.adminservice.services.pipelines.PipelinePassportService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/pipelines/passport",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Паспорт трубопровода",
        description="API для работы с данными паспорта трубопровода")
public class PipelinePassportController {

    private final PipelinePassportService service;

    @Operation(summary = "Добавление данных паспорта")
    @PostMapping
    public ResponseEntity<PipelinePassportDto> save(
            @RequestBody @Parameter(description = "Паспорт") NewPipelinePassportDto passportDto) {
        return ResponseEntity.ok().body(service.save(passportDto));
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public ResponseEntity<PipelinePassportDto> update(
            @RequestBody @Parameter(description = "Паспорт") UpdatePipelinePassportDto passportDto) {
        return ResponseEntity.ok().body(service.update(passportDto));
    }

    @Operation(summary = "Получение полной информации паспорта")
    @GetMapping("/{pasId}")
    public ResponseEntity<PipelinePassportDto> get(
            @PathVariable @Parameter(description = "Индентификатор паспорта") Long pasId) {
        return ResponseEntity.ok().body(service.get(pasId));
    }

    @Operation(summary = "Получение краткой информации паспортов")
    @GetMapping
    public ResponseEntity<List<ShortPipelinePassportDto>> getAll(
            @RequestParam(required = false)
            @Parameter(description = "Индентификатор названия назначения трубопровода")  Long purposePipelineId,
            @RequestParam(required = false)
            @Parameter(description = "Индентификатор адреса местоположения котельной") Long addressId,
            @RequestParam(required = false)
            @Parameter(description = "Местоположение трубопровода на территории котельной") String location) {
        return ResponseEntity.ok().body(service.getAll(purposePipelineId, addressId, location));
    }

    @Operation(summary = "Удаление паспорта")
    @DeleteMapping("/{pasId}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор паспорта") Long pasId) {
        service.delete(pasId);
        return ResponseEntity.ok("Паспорт удален");
    }
}
