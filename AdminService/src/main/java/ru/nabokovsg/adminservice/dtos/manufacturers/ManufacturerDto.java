package ru.nabokovsg.adminservice.dtos.manufacturers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные изготовителя")
public class ManufacturerDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Изготовитель")
    private String name;
}
