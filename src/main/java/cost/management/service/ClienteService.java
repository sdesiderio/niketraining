package cost.management.service;

import java.util.List;

import cost.management.entities.Cliente;

public interface ClienteService {

	Cliente findByPartitaIva(String partitaIva);
	List<Cliente> findByPartitaIvaContaining(String partitaIva);
	
	List<Cliente> findByRagioneSocialeContaining(String ragioneSociale);
	
	List<Cliente> findAll();
	
	List<Cliente> findByCodiceFiscaleContaining(String cf);

	List<Cliente> findByCodiceInterscambioContaining(String ci);
	List<Cliente> findByPecContaining(String pec);

	Cliente addCliente(Cliente cli);

	Cliente updateCliente(Cliente cli, String id);

	Cliente archiveCliente(String id);

}