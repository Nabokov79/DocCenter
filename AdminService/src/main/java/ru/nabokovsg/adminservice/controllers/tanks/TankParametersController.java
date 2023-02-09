package ru.nabokovsg.adminservice.controllers.tanks;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.NewTankParametersDto;
import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.TankParametersDto;
import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.UpdateTankParametersDto;
import ru.nabokovsg.adminservice.services.tanks.TankParametersService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/tank/parameters",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Параметры бака",
        description="API для работы с данными о параметров бака")
public class TankParametersController {

    private final TankParametersService service;

    @Operation(summary = "Добавление новых данных параметров бака")
    @PostMapping
    public ResponseEntity<TankParametersDto> save(@RequestBody @Parameter(description = "Параметры бака")
                                                                              NewTankParametersDto tankParametersDto) {
        return ResponseEntity.ok().body(service.save(tankParametersDto));
    }

    @Operation(summary = "Изменение данных параметров бака")
    @PatchMapping
    public ResponseEntity<TankParametersDto> update(@RequestBody @Parameter(description = "Параметры бака")
                                                                          UpdateTankParametersDto tankParametersDto) {
        return ResponseEntity.ok().body(service.update(tankParametersDto));
    }

    @Operation(summary = "Получение данных параметров баков")
    @GetMapping
    public ResponseEntity<List<TankParametersDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление параметров бака")
    @DeleteMapping("/{parId}")
    public ResponseEntity<String> delete(@PathVariable
                                         @Parameter(description = "Индентификатор параметров бака") Long parId) {
        service.delete(parId);
        return ResponseEntity.ok("Параметры бака удалены.");
    }
}
