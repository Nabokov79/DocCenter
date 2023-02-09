package ru.nabokovsg.adminservice.repositoryes.users;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.users.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByServiceNumber(Integer serviceNumber);
}
