package cost.management.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import cost.management.entities.Azienda;
import cost.management.entities.Dipendente;
import cost.management.entities.DipendenteBean;

public interface DipendenteService {

	Dipendente inserisciDipendente(Dipendente dipendente, int id);

	List<Dipendente> trovaTuttiDipendenti();

	Dipendente aggiornaDipendente(Dipendente dipendente, String codiceFiscale, int aziendaId);

	Optional<Dipendente> trovaDipendentePerCodiceFiscale(String codiceFiscale);

	Dipendente archiviaDipendente(String codiceFiscale);
	
	List<DipendenteBean> trovaTuttiDipendentiBean();
	
	Dipendente aggiornaDipendenteData(Date data, String codiceFiscale);
	
}
