package ru.nabokovsg.adminservice.controllers.users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.users.MeasuringToolDto;
import ru.nabokovsg.adminservice.dtos.users.NewMeasuringToolDto;
import ru.nabokovsg.adminservice.dtos.users.RequestParameters;
import ru.nabokovsg.adminservice.dtos.users.UpdateMeasuringToolDto;
import ru.nabokovsg.adminservice.services.users.MeasuringToolService;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/measuring",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Измерительный инструмент(прибор)",
     description="API для работы с данными измерительных инструментов(приборов)")
public class MeasuringToolController {

    private final MeasuringToolService service;

    @Operation(summary = "Добавление данных нового интструмента(прибора)")
    @PostMapping
    public ResponseEntity<MeasuringToolDto> save(@RequestBody @Parameter(description = "Инструмент(прибор)")
                                                                                 NewMeasuringToolDto newMeasuringTool) {
        return ResponseEntity.ok().body(service.save(newMeasuringTool));
    }

    @Operation(summary = "Изменение данных инструмента(прибора)")
    @PatchMapping
    public ResponseEntity<MeasuringToolDto> update(@RequestBody @Parameter(description = "Инструмент(прибор)")
                                                                           UpdateMeasuringToolDto updateMeasuringTool) {
        return ResponseEntity.ok().body(service.update(updateMeasuringTool));
    }

    @Operation(summary = "Получение инструментов(приборов) по заданным параметрам")
    @GetMapping
    public ResponseEntity<List<MeasuringToolDto>> getAll(
     @RequestParam(required = false) @Parameter(description = "Название") String name,
     @RequestParam(required = false) @Parameter(description = "Модель") String model,
     @RequestParam(required = false) @Parameter(description = "Заводской номер") Integer workNumber,
     @RequestParam(required = false) @Parameter(description = "Дата изготовления") LocalDate manufacturing,
     @RequestParam(required = false) @Parameter(description = "Дата начала эксплуатации") LocalDate exploitation,
     @RequestParam(required = false)
     @Parameter(description = "Индентификатор завода-изготовителя") Long manufacturerId,
     @RequestParam(required = false)
     @Parameter(description = "Индентификатор метрологической организации") Long organizationId,
     @RequestParam(required = false) @Parameter(description = "Индентификатор вида контроля") Long typeId,
     @RequestParam(required = false) @Parameter(description = "Индентификатор сотрудника") Long userId) {
        RequestParameters parameters = new RequestParameters(name, model, workNumber, manufacturing, exploitation,
                                                                   manufacturerId, organizationId, typeId, userId);
        return ResponseEntity.ok().body(service.getAll(parameters));
    }

    @Operation(summary = "Удаление инструмента(прибора)")
    @DeleteMapping("/{meaId}")
    public ResponseEntity<String> delete(@PathVariable
                                         @Parameter(description = "Индентификатор инструмента(прибора)") Long meaId) {
        service.delete(meaId);
        return ResponseEntity.ok("Инструмента/прибора удален.");
    }
}
