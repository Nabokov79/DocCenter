package ru.nabokovsg.adminservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nabokovsg.adminservice.dtos.reportsData.Param;
import ru.nabokovsg.adminservice.dtos.reportsData.ReportDataDto;
import ru.nabokovsg.adminservice.services.ReportDataService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/report/data",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Отчетная документация",
        description="API для работы с данными отчетной документации")
public class ReportDataController {

    private final ReportDataService service;

    @Operation(summary = "Получение данных отчетный документов")
    @GetMapping
    public ResponseEntity<List<ReportDataDto>> getAll(
            @RequestParam(value = "applicationId", required = false)
            @NotNull @Positive @Parameter(description = "Заявка") Long applicationId,
            @RequestParam(value = "userId", required = false)
            @NotNull @Positive @Parameter(description = "Сотрудник") Long userId,
            @RequestParam(value = "addressId", required = false)
            @NotNull @Positive @Parameter(description = "Адрес") Long addressId,
            @RequestParam(value = "number", required = false)
            @NotNull @Positive @Parameter(description = "Номер документа") Integer number,
            @RequestParam(value = "status", required = false)
            @NotNull @Positive @Parameter(description = "Статус документа") String status,
            @RequestParam(value = "date", required = false)
            @NotNull @Positive
            @Parameter(description = "Дата начала периода, за который требуется выдать отчеты") LocalDateTime startDate,
            @RequestParam(value = "date", required = false)
            @NotNull @Positive
            @Parameter(description = "Дата окончания периода, за который требуется выдать отчеты") LocalDateTime endDate) {
        Param param = new Param(applicationId, userId, addressId,number, status, startDate, endDate);
        return ResponseEntity.ok().body(service.getAll(param));
    }
}
