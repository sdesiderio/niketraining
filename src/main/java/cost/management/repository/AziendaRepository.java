package cost.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cost.management.entities.Azienda;

@Repository
public interface AziendaRepository extends JpaRepository<Azienda, Integer> {

	Azienda findAziendaByNome(String aziendaNome);

}
