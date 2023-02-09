package ru.nabokovsg.adminservice.dtos.boilers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.boilers.Boiler;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Краткая информация паспорта котла")
public class ShortBoilerPassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Котел")
    private Boiler boiler;
    @Schema(description = "Адрес местонахождения котельной")
    private Address address;
}
