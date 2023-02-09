package ru.nabokovsg.adminservice.dtos.documentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о документе")
public class UpdateDocumentationDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id document not be blank")
    @Positive(message = "id document be positive")
    private Long id;
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
