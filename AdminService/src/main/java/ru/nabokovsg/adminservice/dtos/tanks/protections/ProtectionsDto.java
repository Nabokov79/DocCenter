package ru.nabokovsg.adminservice.dtos.tanks.protections;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные антикоррозионной защиты")
public class ProtectionsDto {

    @Schema(description = "Индентификатор ")
    private Long id;
    @Schema(description = "Название")
    private String name;
    @Schema(description = "Дата нанесения на стенки бака")
    private LocalDate date;
    @Schema(description = "Номативный документ")
    private Long documentationId;
}
