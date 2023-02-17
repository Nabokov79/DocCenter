package ru.nabokovsg.adminservice.controllers.piplines;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.NewStandardNormPipeDto;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.StandardNormPipeDto;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.UpdateStandardNormPipeDto;
import ru.nabokovsg.adminservice.services.pipelines.StandardNormPipeService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/pipelines/standards/norms",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="ипоразмеры и нормы браковки",
        description="API для работы с данными типоразмеров и норм браковки труб")
public class StandardNormPipeController {

    private final StandardNormPipeService service;

    @Operation(summary = "Добавление новых типоразмеров и норм браковки")
    @PostMapping
    public ResponseEntity<List<StandardNormPipeDto>> save(
            @RequestBody
            @Parameter(description = "Типоразмеры и нормы браковки") List<NewStandardNormPipeDto> pipesDto) {
        return ResponseEntity.ok().body(service.save(pipesDto));
    }

    @Operation(summary = "Изменение информации о типоразмерах и норм браковки")
    @PatchMapping
    public ResponseEntity<List<StandardNormPipeDto>> update(
            @RequestBody
            @Parameter(description = "Типоразмеры и нормы браковки") List<UpdateStandardNormPipeDto> pipesDto) {
        return ResponseEntity.ok().body(service.update(pipesDto));
    }

    @Operation(summary = "Получение данных всех типоразмеров и норм браковки по типу трубопровода")
    @GetMapping
    public ResponseEntity<List<StandardNormPipeDto>> getAll(
            @RequestParam @Parameter(description = "Индентификатор назначения трубопровода") Long typeId) {
        return ResponseEntity.ok().body(service.getAll(typeId));
    }

    @Operation(summary = "Удаление данных типоразмера и нормы браковки")
    @DeleteMapping("/{staId}")
    public ResponseEntity<String> delete(
            @PathVariable @Parameter(description = "Индентификатор типоразмера и нормы браковки") Long staId) {
        service.delete(staId);
        return ResponseEntity.ok( "Значения удалены.");
    }
}
