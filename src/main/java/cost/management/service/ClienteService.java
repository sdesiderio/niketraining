package cost.management.service;

import java.util.List;

import cost.management.entities.Cliente;

public interface ClienteService {

	Cliente trovaPerPartitaIva(String partitaIva);
	List<Cliente> trovaPerPartitaIvaContenente(String partitaIva);
	
	List<Cliente> trovaPerRagioneSocialeContenente(String ragioneSociale);
	
	List<Cliente> trovaTuttiClienti();
	
	List<Cliente> trovaPerCodiceFiscaleContenente(String codiceFiscale);

	List<Cliente> trovaPerCodiceInterscambioContenente(String codiceInterscambio);
	List<Cliente> trovaPerPecContenente(String pec);

	Cliente inserisciCliente(Cliente cliente);

	Cliente aggiornaCliente(Cliente cliente, String id);

	Cliente archiviaCliente(String id);

}