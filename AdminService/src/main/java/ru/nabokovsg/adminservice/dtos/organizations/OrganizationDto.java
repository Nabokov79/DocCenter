package ru.nabokovsg.adminservice.dtos.organizations;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные о организации")
public class OrganizationDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название организации")
    private String name;
}
