package ru.nabokovsg.adminservice.dtos.mounting;

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
@Schema(description = "Данные для изменения информации о монтажной организации")
public class UpdateMountingDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id mounting should not be blank")
    @Positive(message = "id mounting must be positive")
    private Long id;
    @Schema(description = "Монтажная организация")
    @NotBlank(message = "name mounting organization should not be blank")
    private String name;
}
