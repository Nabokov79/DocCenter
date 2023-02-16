package ru.nabokovsg.adminservice.dtos.licenses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения иформации о лицензии")
public class UpdateLicenseDto {

    @Schema(description = "Индентификатор лицензии")
    @NotNull(message = "id should not be blank")
    @Positive(message = "license id can only be positive")
    private Long id;
    @Schema(description = "Индентификатор организации")
    @NotNull(message = "organization id should not be blank")
    @Positive(message = "organization id can only be positive")
    private Long organizationId;
    @Schema(description = "Номер лицензии")
    @NotBlank(message = "number license should not be blank")
    private String number;
    @Schema(description = "Дата выдачи лицензии")
    @NotNull(message = "date license should not be blank")
    private LocalDate date;
}
