package ru.nabokovsg.adminservice.dtos.boilers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.*;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.boilers.Boiler;
import ru.nabokovsg.adminservice.models.documentation.Documentation;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные паспорта котла")
public class BoilerPassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Котел")
    private Boiler boiler;
    @Schema(description = "Автор проекта")
    private Author author;
    @Schema(description = "Номер проекта")
    private String projectNumber;
    @Schema(description = "Завод-изготовитель котла")
    private Manufacturer manufacturer;
    @Schema(description = "Монтажная организация")
    private Mounting mounting;
    @Schema(description = "Дата ввода в эксплуатацию")
    private LocalDate operation;
    @Schema(description = "Дата составления паспорта")
    private LocalDate startPassport;
    @Schema(description = "Адрес местонахождения котельной")
    private Address address;
    @Schema(description = "Список обследований котла")
    private List<Survey> surveys;
    @Schema(description = "Список ремонтов котла")
    private List<Repair> repairs;
    @Schema(description = "Список нормативных документов")
    private List<Documentation> documentation;
}
