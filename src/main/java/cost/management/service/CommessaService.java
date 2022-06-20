package cost.management.service;

import java.util.List;

import cost.management.entities.Cliente;
import cost.management.entities.Commessa;

public interface CommessaService {

	Commessa findByCodice(String codice);

	List<Commessa> findByCodiceContaining(String codice);

	List<Commessa> findAll();

	List<Commessa> findByDescrizioneCommessaContaining(String dc);

	List<Commessa> findByTipologiaCommessaContaining(String tc);

	Commessa addCommessa(Commessa com);

	Commessa updateCommessa(Commessa com, String codice);

	Commessa archiveCommessa(String codice);
	
	void deleteCommessa(String id);

	

}