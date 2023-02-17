package ru.nabokovsg.adminservice.dtos.types;

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
@Schema(description = "Данные для изменения информации о типе объекта")
public class UpdateTypeDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id type should not be blank")
    @Positive(message = "id type must be positive")
    private Long id;
    @Schema(description = "Тип объекта")
    @NotBlank(message = "name type should not be blank")
    private String name;
}
