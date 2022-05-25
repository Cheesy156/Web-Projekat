package vezbe.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vezbe.demo.model.Korisnik;

@Repository
public interface MenadzerRepository extends JpaRepository<Korisnik, Long> {
}