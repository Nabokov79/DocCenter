package ru.nabokovsg.adminservice.dtos.documentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные нового документа")
public class NewDocumentationDto {

    @Schema(description = "Тип документа")
    @NotBlank(message = "type document should not be blank")
    @Min(2)
    private String typeDocument;
    @Schema(description = "Номер документа")
    @NotBlank(message = "number document should not be blank")
    @Min(2)
    private String numberDocument;
    @Schema(description = "Заголовок")
    @NotBlank(message = "description should not be blank")
    @Min(3)
    private String title;
}
