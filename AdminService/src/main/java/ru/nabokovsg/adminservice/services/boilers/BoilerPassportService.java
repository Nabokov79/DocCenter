package ru.nabokovsg.adminservice.services.boilers;

import ru.nabokovsg.adminservice.dtos.boilers.BoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.NewBoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.ShortBoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.UpdateBoilerPassportDto;
import java.util.List;

public interface BoilerPassportService {

    BoilerPassportDto save(NewBoilerPassportDto passportDto);

    BoilerPassportDto update(UpdateBoilerPassportDto passportDto);

    BoilerPassportDto get(Long pasId);

    List<ShortBoilerPassportDto> getAll(Long boilerId, Long addressId);

    void delete(Long pasId);
}
