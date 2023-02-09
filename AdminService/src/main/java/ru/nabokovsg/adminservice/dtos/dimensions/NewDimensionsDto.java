package ru.nabokovsg.adminservice.dtos.dimensions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные новых габаритов")
public class NewDimensionsDto {

    @Schema(description = "Длина или ширина")
    @Positive(message = "height or length can only be positive")
    @NotNull(message = "height or length should not be blank")
    private Integer heightOrLength;
    @Schema(description = "Диаметр")
    @NotNull(message = "diameter should not be blank")
    @Positive(message = "diameter can only be positive")
    private Integer diameter;
    @Schema(description = "Объем")
    @NotNull(message = "volume should not be blank")
    @Positive(message = "volume can only be positive")
    private Integer volume;
}
