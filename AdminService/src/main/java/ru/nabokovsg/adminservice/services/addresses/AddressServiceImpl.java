package ru.nabokovsg.adminservice.services.addresses;

import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.addresses.AddressDto;
import ru.nabokovsg.adminservice.dtos.addresses.NewAddressDto;
import ru.nabokovsg.adminservice.dtos.addresses.UpdateAddressDto;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.addresses.AddressMapper;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.addresses.City;
import ru.nabokovsg.adminservice.models.addresses.QAddress;
import ru.nabokovsg.adminservice.models.addresses.TypeBuilding;
import ru.nabokovsg.adminservice.repositoryes.addresses.AddressRepository;
import ru.nabokovsg.adminservice.repositoryes.addresses.CityRepository;
import ru.nabokovsg.adminservice.repositoryes.addresses.TypeBuildingRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;
    private final CityRepository cityRepository;
    private final TypeBuildingRepository typeBuildingRepository;


    @Override
    public AddressDto save(NewAddressDto addressDto) {
        Address address = mapper.mapToNewAddress(addressDto);
        address.setCity(getCityById(addressDto.getCityId()));
        address.setTypeBuilding(getTypeBuildingById(addressDto.getTypeBuildingId()));
        return mapper.mapToAddressDto(repository.save(address));
    }

    @Override
    public AddressDto update(UpdateAddressDto addressDto) {
        if (repository.existsById(addressDto.getId())) {
            throw new NotFoundException(String.format("address with id=%s not found for update.", addressDto.getId()));
        }
        Address address = mapper.mapToUpdateAddress(addressDto);
        address.setCity(getCityById(addressDto.getCityId()));
        address.setTypeBuilding(getTypeBuildingById(addressDto.getTypeBuildingId()));
        return mapper.mapToAddressDto(repository.save(address));
    }

    @Override
    public List<AddressDto> getAll(Long cityId, Long typeBuildingId, int from, int size) {
        Pageable pageable = PageRequest.of(from / size,size, Sort.by("cityId"));
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if(cityId != null) {
            booleanBuilder.and(QAddress.address.city.id.eq(cityId));
        }
        if(typeBuildingId != null) {
            booleanBuilder.and(QAddress.address.typeBuilding.id.eq(typeBuildingId));
        }
        if(cityId == null && typeBuildingId == null) {
            return mapper.mapToAddressDto(repository.findAll(pageable).getContent());
        }
        List<Address> addresses = repository.findAll(booleanBuilder, pageable).getContent();
        return mapper.mapToAddressDto(addresses);
    }

    @Override
    public String delete(Long addId) {
        Address address = repository.findById(addId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("address with id=%s not found for delete.", addId))
                );
        repository.deleteById(addId);
        return String.join(" ", address.getCity().getName(),
                                                 address.getStreet(),
                                                 address.getHouseNumber().toString());
    }

    private City getCityById(Long citId) {
        return cityRepository.findById(citId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("city with id=%s not found for set", citId))
                );
    }

    private TypeBuilding getTypeBuildingById(Long typId) {
        return typeBuildingRepository.findById(typId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("type building with id=%s not found for delete.", typId))
                );
    }
}
