package ru.nabokovsg.adminservice.dtos.tanks.passport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.*;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.documentation.Documentation;
import ru.nabokovsg.adminservice.models.tanks.Belt;
import ru.nabokovsg.adminservice.models.tanks.Bottom;
import ru.nabokovsg.adminservice.models.tanks.Protections;
import ru.nabokovsg.adminservice.models.tanks.TankParameters;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные паспорта бака")
public class TankPassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер бака")
    private Integer tankNumber;
    @Schema(description = "Параметры бака")
    private TankParameters tankParameters;
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
    @Schema(description = "Дата ввода в эксплуатацию")
    private LocalDate operation;
    @Schema(description = "Дата составления паспорта")
    private LocalDate startPassport;
    @Schema(description = "Габаритные размеры бака")
    private Dimensions dimensions;
    @Schema(description = "Список поясов бака")
    private List<Belt> belts;
    @Schema(description = "Список днища(днищ) бака")
    private List<Bottom> bottoms;
    @Schema(description = "Высота переливной трубы")
    private Float heightPipe;
    @Schema(description = "Антикоррозионная защита")
    private Protections protections;
    @Schema(description = "Адрес местонахождения котельной")
    private Address address;
    @Schema(description = "Список обследований")
    private List<Survey> surveys;
    @Schema(description = "Список ремонтов бака")
    private List<Repair> repairs;
    @Schema(description = "Список нормативных документов")
    private List<Documentation> documentation;
}
