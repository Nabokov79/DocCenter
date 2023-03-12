package ru.nabokovsg.reportservice.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokovsg.reportservice.models.Drawing;
import ru.nabokovsg.reportservice.models.Subsections;
import ru.nabokovsg.reportservice.models.Tables;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового раздела отчета")
public class SectionDto {

    private long id;
    private Integer number;
    private String heading;
    private List<Subsections> subsections;
    private List<Drawing> drawings;
}
