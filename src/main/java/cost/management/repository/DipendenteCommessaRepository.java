package cost.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cost.management.entities.DipendenteCommessa;
import cost.management.entities.DipendenteCommessaPK;

@Repository
public interface DipendenteCommessaRepository extends JpaRepository<DipendenteCommessa, DipendenteCommessaPK>{

	@Query("SELECT dc.id.dipendenteCodiceFiscale FROM DipendenteCommessa dc "
			+ " WHERE dc.id.dipendenteCodiceFiscale = :dipCodiceFiscale and dc.id.commessaCodice = :codiceComm")
	String findCF(String dipCodiceFiscale, String codiceComm);

	
}
