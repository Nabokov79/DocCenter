package ru.nabokovsg.adminservice.dtos.boilers;

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
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные для изменения информации о котле")
public class UpdateBoilerDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "boiler id should not be blank")
    @Positive(message = "boiler id must be positive")
    private Long id;
    @Schema(description = "Индентификатор типа котла")
    @NotNull(message = "type id should not be blank")
    @Positive(message = "type id author must be positive")
    private Long typeId;
    @Schema(description = "Модель котла")
    @NotBlank(message = "model boiler should not be blank")
    private String model;
}
