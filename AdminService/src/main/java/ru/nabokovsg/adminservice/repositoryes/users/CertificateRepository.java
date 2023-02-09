package ru.nabokovsg.adminservice.repositoryes.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.nabokovsg.adminservice.models.users.Certificate;
import javax.transaction.Transactional;

public interface CertificateRepository extends JpaRepository<Certificate, Long>{

    @Modifying
    @Transactional
    @Query("delete from Certificate c where c.user.id = ?1")
    void deleteAllByUserId(Long userId);
}
