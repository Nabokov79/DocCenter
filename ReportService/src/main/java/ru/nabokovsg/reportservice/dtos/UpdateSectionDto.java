package ru.nabokovsg.reportservice.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.reportservice.models.Drawing;
import ru.nabokovsg.reportservice.models.Subsections;
import ru.nabokovsg.reportservice.models.Tables;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации в разделе отчета")
public class UpdateSectionDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "section id should not be blank")
    @Positive(message = "section id can only be positive")
    private Long id;
    @Schema(description = "Номер раздела")
    @NotNull(message = "number section should not be blank")
    @Positive(message = "number section can only be positive")
    private Integer number;
    @Schema(description = "Заголовок раздела")
    @NotBlank(message = "heading should not be blank")
    private String heading;
    @Schema(description = "Список подразделов")
    @NotEmpty(message = "subsections should not be blank")
    private List<Subsections> subsections;
    @Schema(description = "Список чертежей")
    @NotEmpty(message = "subsections should not be blank")
    private List<Drawing> drawings;
    @Schema(description = "Индентификатор шаблона")
    @NotNull(message = "report pattern id should not be blank")
    @Positive(message = "report pattern id can only be positive")
    private Long reportPatternId;
}
