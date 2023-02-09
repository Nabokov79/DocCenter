package ru.nabokovsg.adminservice.dtos.addresses.typeBuilding;

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
@Schema(description = "Данные для изменения информации о типе строения")
public class UpdateTypeBuildingDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "type building id should not be blank")
    @Positive(message = "type building id can only be positive")
    private Long id;
    @Schema(description = "Название строения")
    @NotBlank(message = "name type building should not be blank")
    private String name;
}
