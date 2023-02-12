package ru.nabokovsg.adminservice.controllers.boilers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.boilers.BoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.NewBoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.ShortBoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.UpdateBoilerPassportDto;
import ru.nabokovsg.adminservice.services.boilers.BoilerPassportService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/boilers/passport",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Паспотр котла",
        description="API для работы с данными паспорта котла")
public class BoilerPassportController {

    private final BoilerPassportService service;

    @Operation(summary = "Добавление данных паспорта")
    @PostMapping
    public ResponseEntity<BoilerPassportDto> save(
            @RequestBody @Validated @Parameter(description = "Паспорт") NewBoilerPassportDto passportDto) {
        return ResponseEntity.ok().body(service.save(passportDto));
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public ResponseEntity<BoilerPassportDto> update(
            @RequestBody @Validated @Parameter(description = "Паспорт") UpdateBoilerPassportDto passportDto) {
        return ResponseEntity.ok().body(service.update(passportDto));
    }

    @Operation(summary = "Получение полной информации паспорта")
    @GetMapping("/{pasId}")
    public ResponseEntity<BoilerPassportDto> get(
            @PathVariable @Parameter(description = "Индентификатор паспорта") Long pasId) {
        return ResponseEntity.ok().body(service.get(pasId));
    }

    @Operation(summary = "Получение краткой информации паспортов")
    @GetMapping
    public ResponseEntity<List<ShortBoilerPassportDto>> getAll(
            @RequestParam(required = false)
            @Parameter(description = "Индентификатор котла") Long boilerId,
            @RequestParam(required = false)
            @Parameter(description = "Индентификатор адреса местоположения котельной") Long addressId) {
        return ResponseEntity.ok().body(service.getAll(boilerId, addressId));
    }

    @Operation(summary = "Удаление паспорта")
    @DeleteMapping("/{pasId}")
    public ResponseEntity<String> delete(
            @PathVariable @NotNull @Positive @Parameter(description = "Индентификатор паспорта") Long pasId) {
        service.delete(pasId);
        return ResponseEntity.ok("Паспорт удален");
    }
}
