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
	
	public List<String> trovaDipendentiPerCommessa(Commessa commessa);
	
	List<Commessa> trovaCommessaPerCliente(Cliente cliente);
	
	List<Commessa> trovaCommessaPerCliente(Cliente cliente, String nominativo);
	
	List<Commessa> trovaCommessaPerDataFineCommessaAttuali();
	
	List<Commessa> trovaCommessaPerDataFineCommessaStorico();
	
	public List<Commessa> confrontaCommessaPerDataFineCommessaAttuali(Commessa commessa);
	
	public List<Commessa> confrontaCommessaPerDataFineCommessaStorico(Commessa commessa);
	
	Commessa aggiornaCommessaCliente(String cliente, String codice);

	

}