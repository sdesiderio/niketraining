package cost.management.service;

import java.util.List;
import java.util.Optional;

import cost.management.entities.Azienda;
import cost.management.entities.Dipendente;

public interface DipendenteService {

	Dipendente addDipendente(Dipendente dipendente, int id);

	List<Dipendente> findAllDipendenti();

	Dipendente updateDipendente(Dipendente dipendente, String codiceFiscale, int aziendaId);

	Optional<Dipendente> findDipendenteByCodiceFiscale(String codiceFiscale);

	Dipendente archiveDipendente(String codiceFiscale);
	
	List<Dipendente> findAllDipendentes();
}
