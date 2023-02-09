package ru.nabokovsg.adminservice.repositoryes.boilers;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.boilers.Boiler;
import ru.nabokovsg.adminservice.models.boilers.BoilerPassport;

public interface BoilerPassportRepository extends JpaRepository<BoilerPassport, Long> {

    boolean existsByBoilerAndAddress(Boiler boiler, Address address);
}
