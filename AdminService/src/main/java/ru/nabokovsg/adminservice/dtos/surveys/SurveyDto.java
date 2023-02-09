package ru.nabokovsg.adminservice.dtos.surveys;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.Organization;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные обследования")
public class SurveyDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Дата обследования")
    private LocalDate date;
    @Schema(description = "Обследование")
    private String survey;
    @Schema(description = "Номер отчета обследования")
    private String number;
    @Schema(description = "Организация, проводившая обследование")
    private Organization organization;
}
