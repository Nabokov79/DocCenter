package ru.nabokovsg.adminservice.repositoryes.addresses;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.addresses.TypeBuilding;

public interface TypeBuildingRepository extends JpaRepository<TypeBuilding,Long> {

    boolean existsByName(String name);
}
