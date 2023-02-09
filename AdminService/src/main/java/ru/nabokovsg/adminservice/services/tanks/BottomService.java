package ru.nabokovsg.adminservice.services.tanks;

import ru.nabokovsg.adminservice.dtos.tanks.bottoms.BottomDto;
import ru.nabokovsg.adminservice.dtos.tanks.bottoms.NewBottomDto;
import ru.nabokovsg.adminservice.dtos.tanks.bottoms.UpdateBottomDto;
import java.util.List;

public interface BottomService {

    List<BottomDto> save(List<NewBottomDto> bottomsDto);

    List<BottomDto> update(List<UpdateBottomDto> bottomsDto);

    List<BottomDto> getAll(Integer thicknessBottom, Integer thicknessEdge, Long tankParametersId);

   void delete(Long botId);
}
