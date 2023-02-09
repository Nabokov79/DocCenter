package ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные названия назначения трубопровода")
public class PurposePipelineDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название")
    private String name;
}
