package ru.nabokovsg.adminservice.dtos.repairs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные нового ремонта")
public class NewRepairDto {

    @Schema(description = "Дата ремонта")
    @NotNull(message = "date repair should not be blank")
    private LocalDate date;
    @Schema(description = "Описание ремонта")
    @NotBlank(message = "description repair  should not be blank")
    @Min(3)
    private String description;
    @Schema(description = "Индентификатор организации, выполнившей ремонт")
    @NotNull(message = "organization id should not be blank")
    private Long organizationId;
}
