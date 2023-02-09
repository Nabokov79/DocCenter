package ru.nabokovsg.adminservice.controllers.users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.users.NewOwnerDto;
import ru.nabokovsg.adminservice.dtos.users.OwnerDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateOwnerDto;
import ru.nabokovsg.adminservice.services.users.OwnerService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/owners",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Владелец",
     description="API для работы с данными организации-владельца измерительных средств(приборов)")
public class OwnerController {

    private final OwnerService service;

    @Operation(summary = "Добавление данных организации-владельца измерительных средств(приборов)")
    @PostMapping
    public ResponseEntity<OwnerDto> save(@RequestBody
                                         @Parameter(description = "организаци-владельца") NewOwnerDto ownerDto) {
        return ResponseEntity.ok().body(service.save(ownerDto));
    }

    @Operation(summary = "Изменение данных организации-владельца измерительных средств(приборов)")
    @PatchMapping
    public ResponseEntity<OwnerDto> update(@RequestBody
                                           @Parameter(description = "организаци-владельца") UpdateOwnerDto ownerDto) {
        return ResponseEntity.ok().body(service.update(ownerDto));
    }

    @Operation(summary = "Получение данных организаций- владельцев измерительных средств(приборов)")
    @GetMapping
    public ResponseEntity<List<OwnerDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных организаци-владельца измерительных средств(приборов)")
    @DeleteMapping("/{ownId}")
    public ResponseEntity<String> delete(@PathVariable
                                         @Parameter(description = "Индентификатор организаци-владельца") Long ownId) {
        return ResponseEntity.ok(service.delete(ownId) + " - удален.");
    }
}
