package ru.nabokovsg.adminservice.controllers.addresses;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.addresses.citys.CityDto;
import ru.nabokovsg.adminservice.dtos.addresses.citys.NewCityDto;
import ru.nabokovsg.adminservice.dtos.addresses.citys.UpdateCityDto;
import ru.nabokovsg.adminservice.services.addresses.CityService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/city",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Населенноый пункт",
     description="API для работы с данными населенного пункта")
public class CityController {

    private final CityService service;

    @Operation(summary = "Добавление нового названия населенного пункта")
    @PostMapping
    public ResponseEntity<CityDto> save(
            @RequestBody @Validated @Parameter(description = "Населенный пункт") NewCityDto cityDto) {
        return ResponseEntity.ok().body(service.save(cityDto));
    }

    @Operation(summary = "Изменение данных населенного пункта")
    @PatchMapping
    public ResponseEntity<CityDto> update(
            @RequestBody @Validated @Parameter(description = "Населенный пункт") UpdateCityDto cityDto) {
        return ResponseEntity.ok().body(service.update(cityDto));
    }

    @Operation(summary = "Получение всех населенных пунктов")
    @GetMapping
    public ResponseEntity<List<CityDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление населенного пункта")
    @DeleteMapping("/{citId}")
    public ResponseEntity<String> delete(
            @PathVariable @NotNull @Positive @Parameter(description = "Индентификатор населенного пункта") Long citId) {
        return ResponseEntity.ok(service.delete(citId) + " - удален.");
    }
}
