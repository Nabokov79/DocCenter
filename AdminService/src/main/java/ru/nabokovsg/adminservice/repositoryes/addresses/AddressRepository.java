package ru.nabokovsg.adminservice.repositoryes.addresses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.nabokovsg.adminservice.models.addresses.Address;

public interface AddressRepository extends JpaRepository<Address, Long>, QuerydslPredicateExecutor<Address> {
}

