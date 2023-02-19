package ru.nabokovsg.adminservice.controllers.applications;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.applications.NewWorkDto;
import ru.nabokovsg.adminservice.dtos.applications.UpdateWorkDto;
import ru.nabokovsg.adminservice.dtos.applications.WorkDto;
import ru.nabokovsg.adminservice.services.applications.WorkService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/applications/work",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Вид работы",
        description="API для работы с данными вида проводимой работы")
public class WorkController {

    private final WorkService service;

    @Operation(summary = "Добавление данных автора проекта")
    @PostMapping
    public ResponseEntity<WorkDto> save(@RequestBody @Parameter(description = "Вид работы") NewWorkDto workDto) {
        return ResponseEntity.ok().body(service.save(workDto));
    }

    @Operation(summary = "Изменение данных автора проекта")
    @PatchMapping
    public ResponseEntity<WorkDto> update(@RequestBody @Parameter(description = "Вид работы") UpdateWorkDto workDto) {
        return ResponseEntity.ok().body(service.update(workDto));
    }

    @Operation(summary = "Получение данных авторов проектов")
    @GetMapping
    public ResponseEntity<List<WorkDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных автора проекта")
    @DeleteMapping("/{worId}")
    public ResponseEntity<String> delete(@PathVariable
                                         @Parameter(description = "Индентификатор вида работы") Long worId) {
        service.delete(worId);
        return ResponseEntity.ok(  "Запись удалена");
    }
}
