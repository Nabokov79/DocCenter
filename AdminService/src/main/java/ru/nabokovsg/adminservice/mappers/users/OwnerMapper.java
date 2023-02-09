package ru.nabokovsg.adminservice.mappers.users;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.users.NewOwnerDto;
import ru.nabokovsg.adminservice.dtos.users.OwnerDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateOwnerDto;
import ru.nabokovsg.adminservice.models.users.Owner;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    Owner mapToNewOwner(NewOwnerDto ownerDto);

    OwnerDto mapToOwnerDto(Owner owner);

    Owner mapToUpdateOwner(UpdateOwnerDto ownerDto);

    List<OwnerDto> mapToOwnersDto(List<Owner> owners);
}
