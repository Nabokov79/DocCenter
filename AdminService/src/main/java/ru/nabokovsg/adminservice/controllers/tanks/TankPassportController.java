package ru.nabokovsg.adminservice.controllers.tanks;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.tanks.passport.*;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.models.tanks.Orientation;
import ru.nabokovsg.adminservice.models.tanks.TypeTank;
import ru.nabokovsg.adminservice.services.tanks.TankPassportService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/tanks/passports",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Паспорт бака",
        description="API для работы с паспортами бака")
public class TankPassportController {

    private final TankPassportService service;

    @Operation(summary = "Добавление данных паспорта")
    @PostMapping
    public ResponseEntity<TankPassportDto> save(
                                @RequestBody @Parameter(description = "Паспорт") NewTankPassportDto passportDto) {
        return ResponseEntity.ok().body(service.save(passportDto));
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public ResponseEntity<TankPassportDto> update(
                             @RequestBody @Parameter(description = "Паспорт") UpdateTankPassportDto passportDto) {
        return ResponseEntity.ok().body(service.update(passportDto));
    }

    @Operation(summary = "Получение полной информации паспорта")
    @GetMapping("/{pasId}")
    public ResponseEntity<TankPassportDto> get(
            @PathVariable @Parameter(description = "Индентификатор паспорта") Long pasId) {
        return ResponseEntity.ok().body(service.get(pasId));
    }

    @Operation(summary = "Получение паспортов баков")
    @GetMapping
    public ResponseEntity<List<ShortTankPassportDto>> getAll(
            @RequestParam(required = false)
            @Parameter(description = "Тип бака по назначению") String typeTank,
            @RequestParam(required = false)
            @Parameter(description = "Положение бака") String orientation,
            @RequestParam(required = false)
            @Parameter(description = "Объем бака") Integer volume,
            @RequestParam(required = false)
            @Parameter(description = "Индентификатор адреса местоположения бака") Long addressId) {
        TankSearchParam param = new TankSearchParam(
                TypeTank.from(typeTank)
                        .orElseThrow(() -> new BadRequestException("Unknown type object: " + typeTank)),
                Orientation.from(orientation)
                        .orElseThrow(() -> new BadRequestException("Unknown type object: " + orientation)),
                volume,addressId
        );
        return ResponseEntity.ok().body(service.getAll(param));
    }

    @Operation(summary = "Удаление паспорта")
    @DeleteMapping("/{pasId}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор паспорта") Long pasId) {
        service.delete(pasId);
        return ResponseEntity.ok("Паспорт удален");
    }
}
