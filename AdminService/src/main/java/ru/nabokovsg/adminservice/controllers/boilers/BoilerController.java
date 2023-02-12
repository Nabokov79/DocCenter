package ru.nabokovsg.adminservice.controllers.boilers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.boilers.BoilerDto;
import ru.nabokovsg.adminservice.dtos.boilers.NewBoilerDto;
import ru.nabokovsg.adminservice.dtos.boilers.UpdateBoilerDto;
import ru.nabokovsg.adminservice.services.boilers.BoilerService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/boilers",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Котел",
        description="API для работы с данными котла")
public class BoilerController {

    private final BoilerService service;

    @Operation(summary = "Добавление данных котла")
    @PostMapping
    public ResponseEntity<BoilerDto> save(
                                    @RequestBody @Validated @Parameter(description = "Котел") NewBoilerDto boilerDto) {
        return ResponseEntity.ok().body(service.save(boilerDto));
    }

    @Operation(summary = "Изменение данных котла")
    @PatchMapping
    public ResponseEntity<BoilerDto> update(
                                @RequestBody @Validated @Parameter(description = "Котел") UpdateBoilerDto boilerDto) {
        return ResponseEntity.ok().body(service.update(boilerDto));
    }

    @Operation(summary = "Получение данных авторов проектов")
    @GetMapping
    public ResponseEntity<List<BoilerDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных автора проекта")
    @DeleteMapping("/{boiId}")
    public ResponseEntity<String> delete(
            @PathVariable @NotNull @Positive @Parameter(description = "Индентификатор котла") Long boiId) {
        service.delete(boiId);
        return ResponseEntity.ok("Данные котла удалены");
    }
}
