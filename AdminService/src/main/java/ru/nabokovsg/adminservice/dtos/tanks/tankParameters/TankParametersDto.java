package ru.nabokovsg.adminservice.dtos.tanks.tankParameters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.Type;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные параметраметров бака")
public class TankParametersDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Тип бака, по назначению")
    private Type type;
    @Schema(description = "Положение бака")
    private String orientation;
    @Schema(description = "Объем бака")
    private Integer volume;
}
