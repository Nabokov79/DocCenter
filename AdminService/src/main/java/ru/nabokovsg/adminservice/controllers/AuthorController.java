package ru.nabokovsg.adminservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.author.AuthorDto;
import ru.nabokovsg.adminservice.dtos.author.NewAuthorDto;
import ru.nabokovsg.adminservice.dtos.author.UpdateAuthorDto;
import ru.nabokovsg.adminservice.services.AuthorService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/authors",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Автор проекта",
     description="API для работы с данными о авторе проекта")
public class AuthorController {

    private final AuthorService service;

    @Operation(summary = "Добавление данных автора проекта")
    @PostMapping
    public ResponseEntity<AuthorDto> save(@RequestBody @Parameter(description = "Автор") NewAuthorDto authorDto) {
        return ResponseEntity.ok().body(service.save(authorDto));
    }

    @Operation(summary = "Изменение данных автора проекта")
    @PatchMapping
    public ResponseEntity<AuthorDto> update(@RequestBody @Parameter(description = "Автор") UpdateAuthorDto authorDto) {
        return ResponseEntity.ok().body(service.update(authorDto));
    }

    @Operation(summary = "Получение данных авторов проектов")
    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных автора проекта")
    @DeleteMapping("/{autId}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор автора") Long autId) {
        return ResponseEntity.ok(service.delete(autId) + " - удален.");
    }
}
