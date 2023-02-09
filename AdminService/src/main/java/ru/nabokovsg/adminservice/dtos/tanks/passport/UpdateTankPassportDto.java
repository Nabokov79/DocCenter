package ru.nabokovsg.adminservice.dtos.tanks.passport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные изменения информации в паспорте бака")
public class UpdateTankPassportDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id tank passport should not be blank")
    @Positive(message = "id tank passport must be positive")
    private Long id;
    @Schema(description = "Номер бака")
    @NotNull(message = "tank number should not be blank")
    @Positive(message = "tank number can only be positive")
    private Integer tankNumber;
    @Schema(description = "Индентификатор параметров бака")
    @NotNull(message = "tank parameters id should not be blank")
    @Positive(message = "tank parameters id can only be positive")
    @Positive(message = "tank parameters id can only be positive")
    private Long tankParametersId;
    @Schema(description = "Индентификатор автора проекта")
    @Positive(message = "author id can only be positive")
    private Long authorId;
    @Schema(description = "Номер проекта")
    @Min(value = 1, message = "less than one character entered")
    private String projectNumber;
    @Schema(description = "Индентификатор завода изготовителя бака")
    @Positive(message = "manufacturer id can only be positive")
    private Long manufacturerId;
    @Schema(description = "Индентификатор монтажной организации")
    @Positive(message = "mounting id can only be positive")
    private Long mountingId;
    @Schema(description = "Дата монтажа")
    private LocalDate installation;
    @Schema(description = "Дата ввода в эксплуатацию")
    private LocalDate operation;
    @Schema(description = "Дата составления паспорта")
    private LocalDate startPassport;
    @Schema(description = "Индентификатор записи габаритных размеров бака")
    @Positive(message = "dimensions id can only be positive")
    private Long dimensionsId;
    @Schema(description = "Список индентификаторов поясов(стенки) бака")
    private List<Long> beltsId;
    @Schema(description = "Список индентификаторов днища бака")
    private List<Long> bottomsId;
    @Schema(description = "Высота переливной трубы")
    private Float heightPipe;
    @Schema(description = "Индентификатор антикоррозионной защиты")
    @Positive(message = "protections id can only be positive")
    private Long protectionsId;
    @Schema(description = "Индентификатор адреса местонахождения котельной")
    @NotNull(message = "address id should not be blank")
    @Positive(message = "address id can only be positive")
    private Long addressId;
    @Schema(description = "Список индентификаторов обследований")
    private List<Long> surveysId;
    @Schema(description = "Список индентификаторов ремонтов бака")
    private List<Long> repairsId;
    @Schema(description = "Список индентификаторов нормативных документов")
    @NotNull(message = "documentation should not be blank")
    private List<Long> documentationId;
}
