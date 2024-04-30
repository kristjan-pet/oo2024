package ee.tlu.Kodutoo1.repository;

import ee.tlu.Kodutoo1.entity.PCEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PCRepository extends JpaRepository<PCEntity, String> {

    //http://localhost:8080/api/arvutid-maksumus-min/2000
    List<PCEntity> findAllByMaksumusGreaterThan(int maksumus);

    //http://localhost:8080/api/arvutid-valmistaja/Euronics
    List<PCEntity> findAllByValmistaja(String valmistaja);
}
