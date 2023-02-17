package ru.nabokovsg.adminservice.dtos.tanks.tankParameters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о параметрах бака")
public class UpdateTankParametersDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id type tank should not be blank")
    @Positive(message = "id type tank must be positive")
    private Long id;
    @Schema(description = "Индентификатор типа бака")
    @NotNull(message = "type id should not be blank")
    @Positive(message = "type id author must be positive")
    private Long typeId;
    @Schema(description = "Положение бака")
    @NotBlank(message = "tank orientation should not be blank")
    private String orientation;
    @Schema(description = "Объем бака")
    @NotNull(message = "volume should not be blank")
    @Positive(message = "volume should not be blank")
    private Integer volume;
}
