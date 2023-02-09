package ru.nabokovsg.adminservice.mappers.addresses;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.addresses.AddressDto;
import ru.nabokovsg.adminservice.dtos.addresses.NewAddressDto;
import ru.nabokovsg.adminservice.dtos.addresses.UpdateAddressDto;
import ru.nabokovsg.adminservice.models.addresses.Address;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address mapToNewAddress(NewAddressDto addressDto);

    AddressDto mapToAddressDto(Address address);

    Address mapToUpdateAddress(UpdateAddressDto addressDto);

    List<AddressDto> mapToAddressDto(List<Address> addresses);
}
