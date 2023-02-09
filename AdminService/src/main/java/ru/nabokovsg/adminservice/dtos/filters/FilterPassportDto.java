package ru.nabokovsg.adminservice.dtos.filters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.*;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.documentation.Documentation;
import ru.nabokovsg.adminservice.models.filters.Filter;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные паспорта фильтра")
public class FilterPassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Фильтр")
    private Filter filter;
    @Schema(description = "Номер фильтра")
    private Integer numberFilter;
    @Schema(description = "Автор проекта")
    private Author author;
    @Schema(description = "Номер проекта")
    private String projectNumber;
    @Schema(description = "Завод-изготовитель бака")
    private Manufacturer manufacturerId;
    @Schema(description = "Монтажная организация")
    private Mounting mounting;
    @Schema(description = "Дата монтажа")
    private LocalDate installation;
    @Schema(description = "Расчетный срок службы фильтра")
    private Integer estimatedLife;
    @Schema(description = "Дата ввода в эксплуатацию")
    private LocalDate operation;
    @Schema(description = "Объем")
    private Integer volume;
    @Schema(description = "Дата составления паспорта")
    private LocalDate startPassport;
    @Schema(description = "Габариты фильтра")
    private Dimensions dimensions;
    @Schema(description = "Положение фильтра")
    private String orientation;
    @Schema(description = "Расчетное давление")
    private Integer pressure;
    @Schema(description = "Адрес местонахождения котельной")
    private Address address;
    @Schema(description = "Список обследований")
    private List<Survey> surveys;
    @Schema(description = "Список ремонтов бака")
    private List<Repair> repairs;
    @Schema(description = "Список нормативных документов")
    private List<Documentation> documentation;
}
