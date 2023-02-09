package ru.nabokovsg.adminservice.dtos.mounting;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные монтажной организации")
public class MountingDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Монтажная организация")
    private String name;
}
