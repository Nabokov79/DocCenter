package ru.nabokovsg.adminservice.mappers.tanks;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.tanks.bottoms.BottomDto;
import ru.nabokovsg.adminservice.dtos.tanks.bottoms.NewBottomDto;
import ru.nabokovsg.adminservice.dtos.tanks.bottoms.UpdateBottomDto;
import ru.nabokovsg.adminservice.models.tanks.Bottom;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BottomMapper {

    List<Bottom> mapToNewBottoms(List<NewBottomDto> bottomsDto);

    List<BottomDto> mapToBottomsDto(List<Bottom> bottoms);

    List<Bottom> mapToUpdateBottoms(List<UpdateBottomDto> bottomsDto);
}
