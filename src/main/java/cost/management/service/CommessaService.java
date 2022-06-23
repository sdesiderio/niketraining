package cost.management.service;

import java.util.List;

import cost.management.entities.Cliente;
import cost.management.entities.Commessa;

public interface CommessaService {

	Commessa trovaCommessaPerCodice(String codice);

	List<Commessa> trovaPerCodiceContenente(String codice);

	List<Commessa> trovaTutteCommesse();

	List<Commessa> trovaPerDescrizioneCommessaContenente(String descrizioneCommessa);

	List<Commessa> trovaPerTipologiaCommessaContenente(String tipologiaCommessa);

	Commessa inserisciCommessa(Commessa commessa);

	Commessa aggiornaCommessa(Commessa commessa, String codice);

	Commessa archiviaCommessa(String codice);
	
	void eliminaCommessa(String id);

	

}