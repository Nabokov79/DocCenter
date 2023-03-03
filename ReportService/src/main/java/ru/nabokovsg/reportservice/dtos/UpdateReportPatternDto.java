package ru.nabokovsg.reportservice.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.reportservice.models.Title;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации в шаблоне отчета")
public class UpdateReportPatternDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "report pattern id should not be blank")
    @Positive(message = "report pattern id can only be positive")
    private Long id;
    @Schema(description = "тип объекта обследования")
    @NotBlank(message = "type should not be blank")
    private String type;
    @Schema(description = "Титульный лист отчета")
    @NotNull(message = "title should not be blank")
    private Title title;
}
