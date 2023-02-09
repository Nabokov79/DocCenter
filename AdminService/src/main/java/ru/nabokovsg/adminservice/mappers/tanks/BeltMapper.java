package ru.nabokovsg.adminservice.mappers.tanks;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.tanks.belts.BeltDto;
import ru.nabokovsg.adminservice.dtos.tanks.belts.NewBeltDto;
import ru.nabokovsg.adminservice.dtos.tanks.belts.UpdateBeltDto;
import ru.nabokovsg.adminservice.models.tanks.Belt;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeltMapper {

    List<Belt> mapToNewBelts(List<NewBeltDto> beltsDto);

    List<Belt> mapToUpdateBelts(List<UpdateBeltDto> beltDto);

    List<BeltDto> mapToBeltsDto(List<Belt> belts);
}
