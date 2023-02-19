package ru.nabokovsg.adminservice.dtos.applications;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные вида работы")
public class WorkDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Вид работы")
    private String name;
}
