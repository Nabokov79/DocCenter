package ru.nabokovsg.adminservice.controllers.users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.users.NewUserDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateUserDto;
import ru.nabokovsg.adminservice.dtos.users.UserDto;
import ru.nabokovsg.adminservice.dtos.users.UserShortDto;
import ru.nabokovsg.adminservice.services.users.UserService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/users",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Сотрудники",
     description="API для работы с данными сотрудников")
public class UserController {

    private final UserService service;

    @Operation(summary = "Добавление данных нового сотрудника")
    @PostMapping
    public ResponseEntity<UserShortDto> save(@RequestBody @Parameter(description = "Сотрудник") NewUserDto user) {
        return ResponseEntity.ok().body(service.save(user));
    }

    @Operation(summary = "Изменение данных сотрудника")
    @PatchMapping
    public ResponseEntity<UserShortDto> update(@RequestBody @Parameter(description = "Сотрудник") UpdateUserDto user) {
        return ResponseEntity.ok().body(service.update(user));
    }

    @Operation(summary = "Получение данных сотрудника")
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> get(@PathVariable
                                       @Parameter(description = "Индентификатор сотрудника") Long userId) {
        return ResponseEntity.ok().body(service.get(userId));
    }

    @Operation(summary = "Получение данных всех сотрудников")
    @GetMapping
    public ResponseEntity<List<UserShortDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных сотрудника")
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable
                                         @Parameter(description = "Индентификатор сотрудника") Long userId) {
        service.delete(userId);
        return ResponseEntity.ok("Данные сотрудника удалены.");
    }
}
