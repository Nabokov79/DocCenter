package ru.nabokovsg.adminservice.controllers.tanks;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.tanks.belts.BeltDto;
import ru.nabokovsg.adminservice.dtos.tanks.belts.NewBeltDto;
import ru.nabokovsg.adminservice.dtos.tanks.belts.UpdateBeltDto;
import ru.nabokovsg.adminservice.services.tanks.BeltService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/tanks/belts",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Пояс(стенка) бака",
     description="API для работы с данными пояса(стенки) бака")
public class BeltController {

    private final BeltService service;

    @Operation(summary = "Добавление новых данных пояса(стенки) бака")
    @PostMapping
    public ResponseEntity<List<BeltDto>> save(@RequestBody
                                              @Parameter(description = "Пояс(стенка)")  List<NewBeltDto> beltsDto) {
        return ResponseEntity.ok().body(service.save(beltsDto));
    }

    @Operation(summary = "Изменение данных пояса(стенки) бака")
    @PatchMapping
    public ResponseEntity<List<BeltDto>> update(@RequestBody
                                               @Parameter(description = "Пояс(стенка)") List<UpdateBeltDto> beltsDto) {
        return ResponseEntity.ok().body(service.update(beltsDto));
    }

    @Operation(summary = "Получение значений поясов(стенки) бака")
    @GetMapping
    public ResponseEntity<List<BeltDto>> getAll(
                                     @RequestParam(required = false)
                                     @Parameter(description = "Толщина пояса(стенки)") Integer thickness,
                                     @RequestParam(required = false)
                                     @Parameter(description = "Индентификатор параметров бака") Long tankParametersId) {
        return ResponseEntity.ok().body(service.getAll(thickness, tankParametersId));
    }

    @Operation(summary = "Удаление данных стенки")
    @DeleteMapping("/{belId}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long belId) {
        service.delete(belId);
        return ResponseEntity.ok("Значения удалены.");
    }
}
