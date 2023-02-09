package ru.nabokovsg.adminservice.dtos.manufacturers;

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
@Schema(description = "Данные для изменения информации об изготовителе")
public class UpdateManufacturerDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "manufacturer id should not be blank")
    @Positive(message = "manufacturer id must be positive")
    private Long id;
    @Schema(description = "Изготовитель")
    @NotBlank(message = "name manufacturer should not be blank")
    private String name;
}
