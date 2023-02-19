package ru.nabokovsg.adminservice.controllers.applications;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.applications.*;
import ru.nabokovsg.adminservice.services.applications.ApplicationService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/applications",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Заявка",
        description="API для работы с данными заявки")
public class ApplicationController {

    private final ApplicationService service;

    @Operation(summary = "Добавление данных заявки")
    @PostMapping
    public ResponseEntity<ApplicationDto> save(@RequestBody
                                               @Parameter(description = "Заявка") NewApplicationDto applicationDto) {
        return ResponseEntity.ok().body(service.save(applicationDto));
    }

    @Operation(summary = "Изменение данных заявки")
    @PatchMapping
    public ResponseEntity<ApplicationDto> update(@RequestBody
                                          @Parameter(description = "Заявка") UpdateApplicationDto applicationDto) {
        return ResponseEntity.ok().body(service.update(applicationDto));
    }

    @Operation(summary = "Получение данных авторов проектов")
    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAll(@RequestParam(value = "addressId", required = false)
                                                @NotNull @Positive @Parameter(description = "Адрес") Long addressId,
                                                @RequestParam(value = "startDate", required = false)
                                                @Parameter(description = "Дата начала периода, за который требуется выдать заявки") LocalDateTime startDate,
                                                @RequestParam(value = "endDate", required = false)
                                                @NotNull @Positive
                                                @Parameter(description = "Дата окончания периода, за который требуется выдать заявки") LocalDateTime endDate,
                                                @RequestParam(value = "primary", required = false)
                                                @NotNull @Positive @Parameter(description = "Первичное обсдедование") Boolean primary,
                                                @RequestParam(value = "repeat", required = false)
                                                @NotNull @Positive @Parameter(description = "Повторное обследование") Boolean repeat,
                                                @RequestParam(value = "passport", required = false)
                                                @NotBlank @Parameter(description = "Тип паспорта объекта в базе данных") String passport) {
        ApplicationSearchParam param = new ApplicationSearchParam(addressId, startDate, endDate, primary, repeat, passport);
        return ResponseEntity.ok().body(service.getAll(param));
    }
}
