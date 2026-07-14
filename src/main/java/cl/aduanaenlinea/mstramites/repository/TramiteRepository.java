package cl.aduanaenlinea.mstramites.repository;

import cl.aduanaenlinea.mstramites.model.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TramiteRepository extends JpaRepository<Tramite, Long> {

    Optional<Tramite> findByTramiteId(String tramiteId);

    Optional<Tramite> findByDocNumber(String docNumber);

    List<Tramite> findByUserEmail(String userEmail);
}
