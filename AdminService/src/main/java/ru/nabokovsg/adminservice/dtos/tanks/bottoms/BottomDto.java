package ru.nabokovsg.adminservice.dtos.tanks.bottoms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные параметров днища бака")
public class BottomDto {

    @Schema(description = "Индентификатор ")
    private Long id;
    @Schema(description = "Толщина днища")
    private Integer thicknessBottom;
    @Schema(description = "Пределная допустимая толщина днища")
    private Float normBottom;
    @Schema(description = "Толщина окрайка днища")
    private Integer thicknessEdge;
    @Schema(description = "Минимальная допустимая толщина окрайка днища")
    private Float normEdge;
    @Schema(description = "Индентификатор параметров бака")
    private Long tankParametersId;
}
