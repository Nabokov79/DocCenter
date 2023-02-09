package ru.nabokovsg.adminservice.dtos.tanks.protections;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Новые данные антикоррозионной защиты")
public class NewProtectionsDto {

    @Schema(description = "Название")
    @NotBlank(message = "name should not be blank")
    @Min(3)
    private String name;
    @Schema(description = "Дата нанесения на стенки бака")
    private LocalDate date;
    @Schema(description = "Индентификатор нормативного документа")
    private Long documentationId;
}
