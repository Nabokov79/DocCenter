package ru.nabokovsg.adminservice.services.common;

import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.models.*;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.documentation.Documentation;
import ru.nabokovsg.adminservice.models.pipelines.PurposePipeline;

import java.util.List;

public interface CommonService {

    CommonDto getObjects(RequestIds requestIds);
}
