package ru.nabokovsg.adminservice.controllers.piplines;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.NewOilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.OilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.ShortOilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.UpdateOilPipelinePassportDto;
import ru.nabokovsg.adminservice.services.pipelines.OilPipelinePassportService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/pipelines/oil/passport",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Паспорт мазутопровода",
        description="API для работы с данными паспорта мазутопровода")
public class OilPipelinePassportController {

    private final OilPipelinePassportService service;

    @Operation(summary = "Добавление данных паспорта")
    @PostMapping
    public ResponseEntity<OilPipelinePassportDto> save(
            @RequestBody @Parameter(description = "Паспорт") NewOilPipelinePassportDto passportDto) {
        return ResponseEntity.ok().body(service.save(passportDto));
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public ResponseEntity<OilPipelinePassportDto> update(
            @RequestBody @Parameter(description = "Паспорт") UpdateOilPipelinePassportDto passportDto) {
        return ResponseEntity.ok().body(service.update(passportDto));
    }

    @Operation(summary = "Получение полной информации паспорта")
    @GetMapping("/{pasId}")
    public ResponseEntity<OilPipelinePassportDto> get(
            @PathVariable @Parameter(description = "Индентификатор паспорта") Long pasId) {
        return ResponseEntity.ok().body(service.get(pasId));
    }

    @Operation(summary = "Получение краткой информации паспортов")
    @GetMapping
    public ResponseEntity<List<ShortOilPipelinePassportDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление паспорта")
    @DeleteMapping("/{pasId}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор паспорта") Long pasId) {
        service.delete(pasId);
        return ResponseEntity.ok("Паспорт удален");
    }
}
