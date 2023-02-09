package ru.nabokovsg.adminservice.controllers.filters;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.filters.FilterPassportDto;
import ru.nabokovsg.adminservice.dtos.filters.NewFilterPassportDto;
import ru.nabokovsg.adminservice.dtos.filters.ShortFilterPassportDto;
import ru.nabokovsg.adminservice.dtos.filters.UpdateFilterPassportDto;
import ru.nabokovsg.adminservice.services.filters.FilterPassportService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/passports/filter",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Паспорт фильтра",
    description="API для работы с данными паспорта фильтра")
public class FilterPassportController {

    private final FilterPassportService service;

    @Operation(summary = "Добавление данных паспорта")
    @PostMapping
    public ResponseEntity<FilterPassportDto> save(
            @RequestBody @Parameter(description = "Паспорт") NewFilterPassportDto passportDto) {
        return ResponseEntity.ok().body(service.save(passportDto));
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public ResponseEntity<FilterPassportDto> update(
            @RequestBody @Parameter(description = "Паспорт") UpdateFilterPassportDto passportDto) {
        return ResponseEntity.ok().body(service.update(passportDto));
    }

    @Operation(summary = "Получение полной информации паспорта")
    @GetMapping("/{pasId}")
    public ResponseEntity<FilterPassportDto> get(
            @PathVariable @Parameter(description = "Индентификатор паспорта") Long pasId) {
        return ResponseEntity.ok().body(service.get(pasId));
    }

    @Operation(summary = "Получение краткой информации паспортов")
    @GetMapping
    public ResponseEntity<List<ShortFilterPassportDto>> getAll(
            @RequestParam(required = false)
            @Parameter(description = "Индентификатор фильтра") Long filterId,
            @RequestParam(required = false)
            @Parameter(description = "Индентификатор адреса местоположения котельной") Long addressId) {
        return ResponseEntity.ok().body(service.getAll(filterId, addressId));
    }

    @Operation(summary = "Удаление паспорта")
    @DeleteMapping("/{pasId}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор паспорта") Long pasId) {
        service.delete(pasId);
        return ResponseEntity.ok("Паспорт удален");
    }
}
