package ru.nabokovsg.adminservice.repositoryes.filters;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.filters.FilterPassport;
import ru.nabokovsg.adminservice.models.filters.Filter;

public interface FilterPassportRepository extends JpaRepository<FilterPassport, Long> {

    boolean existsByFilterAndAddress(Filter filter, Address address);
}
