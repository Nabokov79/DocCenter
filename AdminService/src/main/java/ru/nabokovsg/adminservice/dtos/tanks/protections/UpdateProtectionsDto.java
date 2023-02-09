package ru.nabokovsg.adminservice.dtos.tanks.protections;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о антикоррозионной защиты")
public class UpdateProtectionsDto {

    @Schema(description = "Индентификатор ")
    @NotNull(message = "id belt should not be blank")
    @Positive(message = "id belt can only be positive")
    private Long id;
    @Schema(description = "Название")
    @NotBlank(message = "name should not be blank")
    @Min(3)
    private String name;
    @Schema(description = "Дата нанесения на стенки бака")
    private LocalDate date;
    @Schema(description = "Нормативный документ")
    private Long documentationId;
}
