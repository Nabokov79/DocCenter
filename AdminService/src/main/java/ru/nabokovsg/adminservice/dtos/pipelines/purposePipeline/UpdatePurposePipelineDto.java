package ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline;

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
@Schema(description = "Данные для изменения названия назначения трубопровода")
public class UpdatePurposePipelineDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id purpose pipeline should not be blank")
    @Positive(message = "id purpose pipeline must be positive")
    private Long id;
    @Schema(description = "Название")
    @NotBlank(message = "purpose pipeline should not be blank")
    private String name;
}
