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

    @Schema(description = "Номер котла")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number must be positive")
    private Integer number;
    @Schema(description = "Тип котла")
    @NotBlank(message = "type boiler should not be blank")
    private String type;
    @Schema(description = "Модель котла")
    @NotBlank(message = "model boiler should not be blank")
    private String model;
}
