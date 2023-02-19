package ru.nabokovsg.adminservice.dtos.applications;

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
@Schema(description = "Данные для изменения информации о вмде работы")
public class UpdateWorkDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id work should not be blank")
    @Positive(message = "id work must be positive")
    private Long id;
    @Schema(description = "Вид работы")
    @NotBlank(message = "name work should not be blank")
    private String name;
}
