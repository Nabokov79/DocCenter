package ru.nabokovsg.adminservice.controllers.addresses;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.NewTypeBuildingDto;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.TypeBuildingDto;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.UpdateTypeBuildingDto;
import ru.nabokovsg.adminservice.services.addresses.TypeBuildingService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/buildings",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Тип строения",
        description="API для работы с данными типа строения")
public class TypeBuildingController {

    private final TypeBuildingService service;

    @Operation(summary = "Добавление нового типа строения")
    @PostMapping
    public ResponseEntity<TypeBuildingDto> save(
            @RequestBody @Validated @Parameter(description = "Тип строения") NewTypeBuildingDto typeBuildingDto) {
        return ResponseEntity.ok().body(service.save(typeBuildingDto));
    }

    @Operation(summary = "Изменение данных типа строения")
    @PatchMapping
    public ResponseEntity<TypeBuildingDto> update(
            @RequestBody @Validated @Parameter(description = "Тип строения") UpdateTypeBuildingDto typeBuildingDto) {
        return ResponseEntity.ok().body(service.update(typeBuildingDto));
    }

    @Operation(summary = "Получение всех типов строений")
    @GetMapping
    public ResponseEntity<List<TypeBuildingDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление типа строения")
    @DeleteMapping("/{buiId}")
    public ResponseEntity<String> delete(
            @PathVariable @NotNull @Positive @Parameter(description = "Индентификатор типа строения") Long buiId) {
        service.delete(buiId);
        return ResponseEntity.ok( "Запись удалена.");
    }
}
