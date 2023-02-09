package ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные нового названия назначения трубопровода")
public class NewPurposePipelineDto {

    @Schema(description = "Название")
    @NotBlank(message = "purpose pipeline should not be blank")
    private String name;
}
