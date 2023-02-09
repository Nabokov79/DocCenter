package ru.nabokovsg.adminservice.controllers.users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.users.ControlTypeDto;
import ru.nabokovsg.adminservice.dtos.users.NewControlTypeDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateControlTypeDto;
import ru.nabokovsg.adminservice.services.users.ControlTypeService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/controls",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Виды контроля",
     description="API для работы с данными о виде контроля")
public class ControlTypeController {

    private final ControlTypeService service;

    @Operation(summary = "Добавление данных нового вида контроля")
    @PostMapping
    public ResponseEntity<ControlTypeDto> save(@RequestBody
                                               @Parameter(description = "Вид контроля")
                                               NewControlTypeDto typeControlDto) {
        return ResponseEntity.ok().body(service.save(typeControlDto));
    }

    @Operation(summary = "Изменение информации о виде контроля")
    @PatchMapping
    public ResponseEntity<ControlTypeDto> update(@RequestBody
                                                 @Parameter(description = "Вид контроля")
                                                 UpdateControlTypeDto typeControlDto) {
        return ResponseEntity.ok().body(service.update(typeControlDto));
    }

    @Operation(summary = "Получение данных по всем видам контроля")
    @GetMapping
    public ResponseEntity<List<ControlTypeDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных вида контроля")
    @DeleteMapping("/{typId}")
    public ResponseEntity<String> delete(@PathVariable
                                         @Parameter(description = "Индентификатор вида контроля") Long typId) {
        return ResponseEntity.ok(service.delete(typId) + " - удален.");
    }
}
