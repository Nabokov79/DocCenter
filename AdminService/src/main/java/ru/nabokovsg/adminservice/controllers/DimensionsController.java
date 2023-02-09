package ru.nabokovsg.adminservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.dimensions.DimensionsDto;
import ru.nabokovsg.adminservice.dtos.dimensions.NewDimensionsDto;
import ru.nabokovsg.adminservice.dtos.dimensions.UpdateDimensionsDto;
import ru.nabokovsg.adminservice.services.DimensionsService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/dimensions",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Габариты",
        description="API для работы с данными габаритов")
public class DimensionsController {

    private final DimensionsService service;

    @Operation(summary = "Добавление новых габаритов")
    @PostMapping
    public ResponseEntity<DimensionsDto> save(@RequestBody
                                              @Parameter(description = "Габариты") NewDimensionsDto dimensionsDto) {
        return ResponseEntity.ok().body(service.save(dimensionsDto));
    }

    @Operation(summary = "Изменение габаритов.")
    @PatchMapping
    public ResponseEntity<DimensionsDto> update(
                                @RequestBody @Parameter(description = "Габариты") UpdateDimensionsDto dimensionsDto) {
        return ResponseEntity.ok().body(service.update(dimensionsDto));
    }

    @Operation(summary = "Получение габаритов")
    @GetMapping
    public ResponseEntity<List<DimensionsDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных о габаритах")
    @DeleteMapping("/{dimId}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long dimId) {
        service.delete(dimId);
        return ResponseEntity.ok( "Габариты удалены.");
    }
}
