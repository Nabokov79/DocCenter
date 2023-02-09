package ru.nabokovsg.adminservice.dtos.documentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.documentation.TypeObject;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные документа")
public class DocumentationDto {

    @Schema(description = "Индентификатор")
    private long id;
    @Schema(description = "Тип объекта")
    private TypeObject typeObject;
    @Schema(description = "Тип документа")
    private String typeDocument;
    @Schema(description = "Номер документа")
    private String numberDocument;
    @Schema(description = "Заголовок")
    private String title;
}
