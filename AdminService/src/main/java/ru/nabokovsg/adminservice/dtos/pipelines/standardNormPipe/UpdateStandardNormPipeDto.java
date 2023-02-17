package ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о параметрах трубы")
public class UpdateStandardNormPipeDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = " id standard and norm pipe should not be blank")
    @Positive(message = "id standard and norm pipe can only be positive")
    private Long id;
    @Schema(description = "Индентификатор назначения трубопровода")
    @NotNull(message = "type id should not be blank")
    @Positive(message = "type id author must be positive")
    private Long typeId;
    @Schema(description = "Диаметр")
    @NotNull(message = "diameter should not be blank")
    @Positive(message = "diameter can only be positive")
    private Integer diameter;
    @Schema(description = "Толщина стенки")
    @NotNull(message = "thickness should not be blank")
    @Positive(message = "thickness only be positive")
    private Float thickness;
    @Schema(description = "Минимальная допустимая толщина стенки")
    @NotNull(message = "min should not be blank")
    @Positive(message = "min can only be positive")
    private Float min;
}
