package ru.nabokovsg.adminservice.dtos.licenses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.Organization;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные лицензии")
public class LicenseDto {

    @Schema(description = "Индентификатор лицензии")
    private Long id;
    @Schema(description = "Организация")
    private Organization organization;
    @Schema(description = "Номер лицензии")
    @NotBlank(message = "number license should not be blank")
    private String number;
    @Schema(description = "Дата выдачи лицензии")
    @NotNull(message = "date license should not be blank")
    private LocalDate date;
}
