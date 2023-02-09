package ru.nabokovsg.adminservice.repositoryes.addresses;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.addresses.City;

public interface CityRepository extends JpaRepository<City, Long> {

    boolean existsByName(String name);
}
