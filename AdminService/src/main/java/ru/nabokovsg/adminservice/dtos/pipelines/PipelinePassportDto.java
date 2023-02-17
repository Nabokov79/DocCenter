package ru.nabokovsg.adminservice.dtos.pipelines;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.Type;
import ru.nabokovsg.adminservice.models.*;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.documentation.Documentation;
import ru.nabokovsg.adminservice.models.pipelines.StandardNormPipe;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class PipelinePassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название назначения трубопровода")
    private Type type;
    @Schema(description = "Атор проекта")
    private Author author;
    @Schema(description = "Номер проекта")
    private String projectNumber;
    @Schema(description = "Завод-изготовитель трубопровода")
    private Manufacturer manufacturerId;
    @Schema(description = "Монтажная организация")
    private Mounting mounting;
    @Schema(description = "Дата монтажа")
    private LocalDate installation;
    @Schema(description = "Дата ввода в эксплуатацию")
    private LocalDate operation;
    @Schema(description = "Дата составления паспорта")
    private LocalDate startPassport;
    @Schema(description = "Список типоразмеров и норм браковки")
    private List<StandardNormPipe> standardNormPipes;
    @Schema(description = "Адрес местонахождения котельной")
    private Address address;
    @Schema(description = "Местоположение трубопровода на территории котельной")
    private String location;
    @Schema(description = "Список обследований")
    private List<Survey> surveys;
    @Schema(description = "Список ремонтов трубопровода")
    private List<Repair> repairs;
    @Schema(description = "Список нормативных документов")
    private List<Documentation> documentation;
}
