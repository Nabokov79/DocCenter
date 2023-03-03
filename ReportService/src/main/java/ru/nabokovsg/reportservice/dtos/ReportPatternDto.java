package ru.nabokovsg.reportservice.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokovsg.reportservice.models.Sections;
import ru.nabokovsg.reportservice.models.Title;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные шаблона отчета")
public class ReportPatternDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "тип объекта обследования")
    private String type;
    @Schema(description = "Титульный лист отчета")
    private Title title;
    @Schema(description = "Разделы отчета")
    private List<Sections> sections;

    @Override
    public String toString() {
        return "ReportPatternDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title=" + title +
                ", sections=" + sections +
                '}';
    }
}
