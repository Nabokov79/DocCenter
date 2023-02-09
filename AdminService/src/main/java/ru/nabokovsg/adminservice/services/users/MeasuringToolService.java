package ru.nabokovsg.adminservice.services.users;

import ru.nabokovsg.adminservice.dtos.users.MeasuringToolDto;
import ru.nabokovsg.adminservice.dtos.users.NewMeasuringToolDto;
import ru.nabokovsg.adminservice.dtos.users.RequestParameters;
import ru.nabokovsg.adminservice.dtos.users.UpdateMeasuringToolDto;

import java.util.List;

public interface MeasuringToolService {

    MeasuringToolDto save(NewMeasuringToolDto newMeasuringTool);

    MeasuringToolDto update(UpdateMeasuringToolDto updateMeasuringTool);

    List<MeasuringToolDto> getAll(RequestParameters parameters);

    void delete(Long meaId);
}
