package ru.nabokovsg.adminservice.dtos.tanks.bottoms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для обновления информации о днище бака")
public class UpdateBottomDto {

    @Schema(description = "Индентификатор ")
    @NotNull(message = "id bottom should not be blank")
    @Positive(message = "id bottom can only be positive")
    private Long id;
    @Schema(description = "Толщина днища")
    @NotNull(message = "thickness bottom should not be blank")
    @Positive(message = "thickness bottom can only be positive")
    private Integer thicknessBottom;
    @Schema(description = "Пределная допустимая толщина днища")
    @NotNull(message = "norm bottom should not be blank")
    @Positive(message = "norm bottom can only be positive")
    private Float normBottom;
    @Schema(description = "Толщина окрайка днища")
    @NotNull(message = "thickness edge should not be blank")
    @Positive(message = "thickness edge only be positive")
    private Integer thicknessEdge;
    @Schema(description = "Минимальная допустимая толщина окрайка днища")
    @NotNull(message = "norm edge should not be blank")
    @Positive(message = "norm edge can only be positive")
    private Float normEdge;
    @Schema(description = "Индентификатор параметров бака")
    @NotNull(message = "tank parameters for bottom id should not be blank")
    @Positive(message = "tank parameters id for bottom only be positive")
    private Long tankParametersId;
}
