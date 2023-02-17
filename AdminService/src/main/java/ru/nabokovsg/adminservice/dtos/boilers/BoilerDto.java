package ru.nabokovsg.adminservice.dtos.boilers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.Type;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные котла")
public class BoilerDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Тип котла")
    private Type type;
    @Schema(description = "Модель котла")
    private String model;
}
