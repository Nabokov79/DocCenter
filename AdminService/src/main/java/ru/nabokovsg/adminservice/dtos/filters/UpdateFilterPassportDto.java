package ru.nabokovsg.adminservice.dtos.filters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации паспорта фильтра")
public class UpdateFilterPassportDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id tank passport should not be blank")
    @Positive(message = "id tank passport must be positive")
    private Long id;
    @Schema(description = "Индентификатор фильтра")
    @NotNull(message = "filter id should not be blank")
    @Positive(message = "filter id can only be positive")
    private Long filterId;
    @Schema(description = "Номер фильтра")
    @NotNull(message = "filter number should not be blank")
    @Positive(message = "filter number can only be positive")
    private Integer numberFilter;
    @Schema(description = "Индентификатор автора проекта")
    @Positive(message = "author id can only be positive")
    private Long authorId;
    @Schema(description = "номер проекта")
    @Min(value = 1, message = "less than one character entered")
    private String projectNumber;
    @Schema(description = "Индентификатор завода изготовителя фильтра")
    @Positive(message = "manufacturer id can only be positive")
    private Long manufacturerId;
    @Schema(description = "Индентификатор монтажной организации")
    @Positive(message = "mounting id can only be positive")
    private Long mountingId;
    @Schema(description = "Дата монтажа")
    private LocalDate installation;
    @Schema(description = "Расчетный срок службы фильтра")
    @Positive(message = "estimated life can only be positive")
    private Integer estimatedLife;
    @Schema(description = "Дата ввода в эксплуатацию")
    private LocalDate operation;
    @Schema(description = "Объем")
    private Integer volume;
    @Schema(description = "Дата составления паспорта")
    private LocalDate startPassport;
    @Schema(description = "Индентификатор габаритов фильтра")
    @Positive(message = "dimensions id can only be positive")
    private Long dimensionsId;
    @Schema(description = "Положение фильтра")
    @NotBlank(message = "orientation should not be blank")
    private String orientation;
    @Schema(description = "Расчетное давление")
    private Integer pressure;
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
