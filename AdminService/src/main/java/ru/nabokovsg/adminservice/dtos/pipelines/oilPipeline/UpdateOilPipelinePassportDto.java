package ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline;

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
@Schema(description = "Данные для изменения информации паспорта мазутопровода")
public class UpdateOilPipelinePassportDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "oil pipeline passport id should not be blank")
    @Positive(message = "oil pipeline passport id must be positive")
    private Long id;
    @Schema(description = "Индентификатор назначения трубопровода")
    @NotNull(message = "type id should not be blank")
    @Positive(message = "type id author must be positive")
    private Long typeId;
    @Schema(description = "Индентификатор атора проекта")
    @Positive(message = "author id can only be positive")
    private Long authorId;
    @Schema(description = "Номер проекта")
    @Min(value = 1, message = "less than one character entered")
    private String projectNumber;
    @Schema(description = "Индентификатор завода изготовителя трубопровода")
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
    @Schema(description = "Список индентификаторов типоразмеров и норм браковки")
    private List<Long> standardNormPipesId;
    @Schema(description = "Рабочее давление подающего мазутопровода")
    private String directPressure;
    @Schema(description = "Разрешенная рабочая температура подающего мазутопровода")
    private String directTemperature;
    @Schema(description = "Рабочее давление обратного  мазутопровода")
    private String backPressure;
    @Schema(description = "Разрешенная рабочая температура обратного мазутопровода")
    private String backTemperature;
    @Schema(description = "Рабочее температура")
    private String temperature;
    @Schema(description = "Индентификатор адреса местонахождения котельной")
    @NotNull(message = "address id should not be blank")
    @Positive(message = "address id can only be positive")
    private Long addressId;
    @Schema(description = "Список индентификаторов обследований")
    private List<Long> surveysId;
    @Schema(description = "Список индентификаторов ремонтов мазутопровода")
    private List<Long> repairsId;
    @Schema(description = "Список индентификаторов нормативных документов")
    @NotNull(message = "documentation should not be blank")
    private List<Long> documentationId;
}
