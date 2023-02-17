package ru.nabokovsg.adminservice.dtos.author;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные автора проекта")
public class AuthorDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Автор проекта")
    private String name;
}
