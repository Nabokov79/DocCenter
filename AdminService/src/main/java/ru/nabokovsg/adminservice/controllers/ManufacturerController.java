package ru.nabokovsg.adminservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.manufacturers.ManufacturerDto;
import ru.nabokovsg.adminservice.dtos.manufacturers.NewManufacturerDto;
import ru.nabokovsg.adminservice.dtos.manufacturers.UpdateManufacturerDto;
import ru.nabokovsg.adminservice.services.ManufacturerService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/manufacturers",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Изготовитель",
     description="API для работы с данными завода-изготовителя")
public class ManufacturerController {

    private final ManufacturerService service;

    @Operation(summary = "Добавление данных завода-изготовителя")
    @PostMapping
    public ResponseEntity<ManufacturerDto> save(@RequestBody @Parameter(description = "Завод-изготовитель")
                                                                                NewManufacturerDto manufacturerDto) {
        return ResponseEntity.ok().body(service.save(manufacturerDto));
    }

    @Operation(summary = "Изменение данных завода-изготовителя")
    @PatchMapping
    public ResponseEntity<ManufacturerDto> update(@RequestBody @Parameter(description = "Завод-изготовитель")
                                                                              UpdateManufacturerDto manufacturerDto) {
        return ResponseEntity.ok().body(service.update(manufacturerDto));
    }

    @Operation(summary = "Получение данных заводов-изготовителей")
    @GetMapping
    public ResponseEntity<List<ManufacturerDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных завода-изготовителя")
    @DeleteMapping("/{manId}")
    public ResponseEntity<String> delete(@PathVariable
                                         @Parameter(description = "Индентификатор завода-изготовителя") Long manId) {
        return ResponseEntity.ok(service.delete(manId) + " - удален.");
    }
}
