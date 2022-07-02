package vezbe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vezbe.demo.model.PoruceniArtikli;
import vezbe.demo.model.Porudzbina;

@Repository
public interface PoruceniArtikliRepository extends JpaRepository<PoruceniArtikli, Long> {
}
