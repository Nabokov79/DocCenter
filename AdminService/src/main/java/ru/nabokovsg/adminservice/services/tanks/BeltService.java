package ru.nabokovsg.adminservice.services.tanks;

import ru.nabokovsg.adminservice.dtos.tanks.belts.BeltDto;
import ru.nabokovsg.adminservice.dtos.tanks.belts.NewBeltDto;
import ru.nabokovsg.adminservice.dtos.tanks.belts.UpdateBeltDto;

import java.util.List;

public interface BeltService {

    List<BeltDto> save(List<NewBeltDto> beltsDto);

    List<BeltDto> update(List<UpdateBeltDto> beltsDto);

    List<BeltDto> getAll(Integer thickness, Long tankParametersId);

    void delete(Long belId);
}
