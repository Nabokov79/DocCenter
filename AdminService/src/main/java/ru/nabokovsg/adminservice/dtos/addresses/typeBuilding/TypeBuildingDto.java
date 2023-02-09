package ru.nabokovsg.adminservice.dtos.addresses.typeBuilding;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные типа строения")
public class TypeBuildingDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название строения")
    private String name;
}
