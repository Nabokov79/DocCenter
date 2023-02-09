package ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.pipelines.PurposePipeline;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные параметров трубы")
public class StandardNormPipeDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Назначение трубопровода")
    private PurposePipeline purposePipeline;
    @Schema(description = "Диаметр")
    private Integer diameter;
    @Schema(description = "Толщина стенки")
    private Float thickness;
    @Schema(description = "Минимальная допустимая толщина стенки")
    private Float min;
}
