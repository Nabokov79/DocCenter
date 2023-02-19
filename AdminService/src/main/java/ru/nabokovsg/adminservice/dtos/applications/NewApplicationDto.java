package ru.nabokovsg.adminservice.dtos.applications;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные новой заявки")
public class NewApplicationDto {

    @Schema(description = "Дата проведения работ")
    @NotNull(message = "date should not be blank")
    private LocalDate date;
    @Schema(description = "Индентификатор адреса местонахождения котельной")
    @NotNull(message = "address id should not be blank")
    @Positive(message = "address id can only be positive")
    private Long addressId;
    @Schema(description = "Индентификатор вида проводимых работ")
    @NotNull(message = "work id should not be blank")
    @Positive(message = "work id can only be positive")
    private Long workId;
    @Schema(description = "Тип паспорта объекта в базе данных")
    @NotNull(message = "address id should not be blank")
    private String passportType;
    @Schema(description = "Индентификатор типа объекта обследования")
    @NotNull(message = "type id should not be blank")
    private Long typeId;
    @Schema(description = "Номер объекта")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number id can only be positive")
    private Integer number;
    @Schema(description = "Положение бака, деаэратора")
    private String orientation;
    @Schema(description = "Объем бака, деаэратора")
    private Integer volume;
    @Schema(description = "Первичное обсдедование")
    @NotNull(message = "primary should not be blank")
    private Boolean primary;
    @Schema(description = "Повторное обследование")
    @NotNull(message = "repeat should not be blank")
    private Boolean repeat;
    @Schema(description = "Примечание")
    private String note;
}
