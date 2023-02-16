package ru.nabokovsg.adminservice.dtos.divisions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о подразделении")
public class UpdateDivisionDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be blank")
    @Positive(message = "id must be positive")
    private Long id;
    @Schema(description = "Индентификатор города")
    @NotNull(message = "city id should not be blank")
    @Positive(message = "city id must be positive")
    private Long cityId;
    @Schema(description = "Индентификатор организации")
    @NotNull(message = "organization id should not be blank")
    @Positive(message = "organization id must be positive")
    private Long organizationId;
    @Schema(description = "Почтовый индекс")
    @NotNull(message = "index should not be blank")
    @Positive(message = "index must be positive")
    private Integer index;
    @Schema(description = "Название подразделения")
    @NotBlank(message = " branch should not be blank")
    private String branch;
    @Schema(description = "Индентификатор лицензии")
    @NotNull(message = "license id should not be blank")
    @Positive(message = "license id must be positive")
    private Long licenseId;
}
