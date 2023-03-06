package ru.nabokovsg.reportservice.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokovsg.reportservice.models.DrawingSection;
import ru.nabokovsg.reportservice.models.Subsections;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные нового раздела отчета")
public class NewSectionDto {

    @Schema(description = "Номер раздела")
    @NotNull(message = "number section should not be blank")
    @Positive(message = "number section can only be positive")
    private Integer numberSection;
    @Schema(description = "Заголовок раздела")
    @NotBlank(message = "heading should not be blank")
    private String heading;
    @Schema(description = "Список подразделов")
    private List<Subsections> subsections;
    @Schema(description = "Список подразделов")
    private List<DrawingSection> drawing;
    @Schema(description = "Индентификатор шаблона")
    @NotNull(message = "report pattern id should not be blank")
    @Positive(message = "report pattern id can only be positive")
    private Long reportPatternId;
}
