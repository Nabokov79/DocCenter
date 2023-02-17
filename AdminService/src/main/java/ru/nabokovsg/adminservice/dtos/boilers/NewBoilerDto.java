package ru.nabokovsg.adminservice.dtos.boilers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового котла")
public class NewBoilerDto {

    @Schema(description = "Индентификатор типа котла")
    @NotNull(message = "type id should not be blank")
    @Positive(message = "type id author must be positive")
    private Long typeId;
    @Schema(description = "Модель котла")
    @NotBlank(message = "model boiler should not be blank")
    private String model;
}
