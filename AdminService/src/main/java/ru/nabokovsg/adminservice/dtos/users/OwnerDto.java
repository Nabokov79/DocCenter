package ru.nabokovsg.adminservice.dtos.users;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Организация-владельц измерительных средств(приборов)")
public class OwnerDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название")
    private String name;
}
