package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.Type;
import ru.nabokovsg.adminservice.dtos.types.NewTypeDto;
import ru.nabokovsg.adminservice.dtos.types.TypeDto;
import ru.nabokovsg.adminservice.dtos.types.UpdateTypeDto;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    Type mapToNewType(NewTypeDto typeDto);

    TypeDto mapToTypeDto(Type type);

    Type mapToUpdateType(UpdateTypeDto typeDto);

    List<TypeDto> mapToTypesDto(List<Type> types);
}
