package ru.nabokovsg.adminservice.controllers.tanks;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.adminservice.dtos.tanks.bottoms.BottomDto;
import ru.nabokovsg.adminservice.dtos.tanks.bottoms.NewBottomDto;
import ru.nabokovsg.adminservice.dtos.tanks.bottoms.UpdateBottomDto;
import ru.nabokovsg.adminservice.services.tanks.BottomService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
        value = "/admin/tanks/bottoms",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Днище бака",
        description="API для работы с данными элементов дна бака")
public class BottomController {

    private final BottomService service;

    @Operation(summary = "Добавление новых данных элементов дна бака")
    @PostMapping
    public ResponseEntity<List<BottomDto>> save(@RequestBody @Valid List<NewBottomDto> bottomsDto) {
        return ResponseEntity.ok().body(service.save(bottomsDto));
    }

    @Operation(summary = "Изменение данных элементов дна бака")
    @PatchMapping
    public ResponseEntity<List<BottomDto>> update(@RequestBody @Valid List<UpdateBottomDto> bottomsDto) {
        return ResponseEntity.ok().body(service.update(bottomsDto));
    }

    @Operation(summary = "Получение данных дна бака")
    @GetMapping
    public ResponseEntity<List<BottomDto>> getAll(
                                     @RequestParam(required = false)
                                     @Parameter(description = "Толщина дна)") Integer thicknessBottom,
                                     @RequestParam(required = false)
                                     @Parameter(description = "Толщина окрайка дна)") Integer thicknessEdge,
                                     @RequestParam(required = false)
                                     @Parameter(description = "Индентификатор параметров бака") Long tankParametersId) {
        return ResponseEntity.ok().body(service.getAll(thicknessBottom, thicknessEdge, tankParametersId));
    }

    @Operation(summary = "Удаление значений дна бака по id")
    @DeleteMapping("/{botId}")
    public ResponseEntity<String> delete(@PathVariable Long botId) {
        service.delete(botId);
        return ResponseEntity.ok( "Значения удалены.");
    }
}
