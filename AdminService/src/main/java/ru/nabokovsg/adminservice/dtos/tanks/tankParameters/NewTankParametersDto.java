package ru.nabokovsg.adminservice.dtos.tanks.tankParameters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные новых параметров бака")
public class NewTankParametersDto {

    @Schema(description = "Тип бака, по назначению")
    @NotBlank(message = "type tank should not be blank")
    private String typeTank;
    @Schema(description = "Положение бака")
    @NotBlank(message = "tank orientation should not be blank")
    private String orientation;
    @Schema(description = "Объем бака")
    @NotNull(message = "volume should not be blank")
    @Positive(message = "volume should not be blank")
    private Integer volume;
}
