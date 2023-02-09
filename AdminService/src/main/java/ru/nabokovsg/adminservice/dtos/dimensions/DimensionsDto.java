package ru.nabokovsg.adminservice.dtos.dimensions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные габаритов")
public class DimensionsDto {

    @Schema(description = "Индентификатор ")
    private Long id;
    @Schema(description = "Длина или ширина")
    private Integer heightOrLength;
    @Schema(description = "Диаметр")
    private Integer diameter;
    @Schema(description = "Объем")
    private Integer volume;
}
