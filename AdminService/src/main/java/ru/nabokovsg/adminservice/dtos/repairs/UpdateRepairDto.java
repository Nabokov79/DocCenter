package ru.nabokovsg.adminservice.dtos.repairs;

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
@Schema(description = "Данные для изменения информации о ремонте")
public class UpdateRepairDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "repair id should not be blank")
    @Positive(message = "repair id must be positive")
    private Long id;
    @Schema(description = "Дата ремонта")
    @NotNull(message = "date repair should not be blank")
    private LocalDate date;
    @Schema(description = "Описание ремонта")
    @NotBlank(message = "description repair should not be blank")
    @Min(3)
    private String description;
    @Schema(description = "Индентификатор организации, выполнившей ремонт")
    @NotNull(message = "organization id should not be blank")
    private Long organizationId;
}
