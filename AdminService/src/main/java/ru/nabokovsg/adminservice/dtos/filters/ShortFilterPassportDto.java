package ru.nabokovsg.adminservice.dtos.filters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.filters.Filter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Краткая информация из паспорта фильтра")
public class ShortFilterPassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Фильтр")
    private Filter filter;
    @Schema(description = "Номер фильтра")
    private Integer numberFilter;
    @Schema(description = "Объем")
    private Integer volume;
    @Schema(description = "Адрес местонахождения котельной")
    private Address address;
}
