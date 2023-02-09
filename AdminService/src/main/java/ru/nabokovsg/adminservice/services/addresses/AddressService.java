package ru.nabokovsg.adminservice.services.addresses;

import ru.nabokovsg.adminservice.dtos.addresses.AddressDto;
import ru.nabokovsg.adminservice.dtos.addresses.NewAddressDto;
import ru.nabokovsg.adminservice.dtos.addresses.UpdateAddressDto;
import java.util.List;

public interface AddressService {

    AddressDto save(NewAddressDto addressDto);

    AddressDto update(UpdateAddressDto addressDto);

    List<AddressDto> getAll(Long cityId, Long typeBuildingId, int from, int size);

    String delete(Long addId);
}
