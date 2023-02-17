package ru.nabokovsg.adminservice.dtos.boilers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.boilers.Boiler;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Краткая информация паспорта котла")
public class ShortBoilerPassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер котла")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number must be positive")
    private Integer number;
    @Schema(description = "Котел")
    private Boiler boiler;
    @Schema(description = "Адрес местонахождения котельной")
    private Address address;
}
