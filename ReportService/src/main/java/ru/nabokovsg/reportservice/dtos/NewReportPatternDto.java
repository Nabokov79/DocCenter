package ru.nabokovsg.reportservice.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokovsg.reportservice.models.Title;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового шаблона отчета")
public class NewReportPatternDto {

    @Schema(description = "тип объекта обследования")
    @NotBlank(message = "type should not be blank")
    private String type;
    @Schema(description = "Титульный лист отчета")
    @NotNull(message = "title should not be blank")
    private Title title;
}
