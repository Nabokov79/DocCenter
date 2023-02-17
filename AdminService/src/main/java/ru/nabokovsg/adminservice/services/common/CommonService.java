package ru.nabokovsg.adminservice.services.common;

import ru.nabokovsg.adminservice.models.Type;
import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.dtos.DivisionIds;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.users.MeasuringToolIds;
import ru.nabokovsg.adminservice.models.*;
import ru.nabokovsg.adminservice.models.users.MeasuringTool;

public interface CommonService {

    CommonDto getObjects(RequestIds requestIds);

    MeasuringTool setMeasuringToolValue(MeasuringTool measuringTool, MeasuringToolIds ids);

    Division setDivisionValue(Division division, DivisionIds ids);

    Type getType(Long typId);
}
