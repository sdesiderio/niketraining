package cost.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cost.management.entities.Dipendente;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, String> {


	public Dipendente findByCodiceFiscale(String codiceFiscale);
	

	
		
		
	
}
