package ru.nabokovsg.adminservice.dtos.divisions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.City;
import ru.nabokovsg.adminservice.models.License;
import ru.nabokovsg.adminservice.models.Organization;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные подразделения")
public class DivisionDto {

    private Long id;
    @Schema(description = "Город")
    private City city;
    @Schema(description = "Организация")
    private Organization organization;
    @Schema(description = "Почтовый индекс")
    private Integer index;
    @Schema(description = "Название подразделения")
    private String branch;
    @Schema(description = "Индентификатор лицензии")
    private License license;
}
