package ru.nabokovsg.adminservice.controllers.filters;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.filters.FilterDto;
import ru.nabokovsg.adminservice.dtos.filters.NewFilterDto;
import ru.nabokovsg.adminservice.dtos.filters.UpdateFilterDto;
import ru.nabokovsg.adminservice.services.filters.FilterService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/filters",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Фильтр",
        description="API для работы с данными фильтров")
public class FilterController {

    private final FilterService service;

    @Operation(summary = "Добавление данных фильтра")
    @PostMapping
    public ResponseEntity<FilterDto> save(@RequestBody @Parameter(description = "Фильтр") NewFilterDto filterDto) {
        return ResponseEntity.ok().body(service.save(filterDto));
    }

    @Operation(summary = "Изменение данных фильтра")
    @PatchMapping
    public ResponseEntity<FilterDto> update(@RequestBody @Parameter(description = "Фильтр") UpdateFilterDto filterDto) {
        return ResponseEntity.ok().body(service.update(filterDto));
    }

    @Operation(summary = "Получение данных фильтров")
    @GetMapping
    public ResponseEntity<List<FilterDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных фильтраа")
    @DeleteMapping("/{filId}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор фильтра") Long filId) {
        service.delete(filId);
        return ResponseEntity.ok("Фильтр удален.");
    }
}
