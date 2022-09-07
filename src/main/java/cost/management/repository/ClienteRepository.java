package cost.management.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cost.management.entities.Cliente;
import cost.management.entities.Commessa;
@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	public List<Cliente> findByRagioneSocialeContaining(String ragioneSociale);
	public Cliente findByPartitaIva(String partitaIva);
	public List<Cliente> findByPartitaIvaContaining(String partitaIva);
	public List<Cliente> findByCodiceFiscaleContaining(String codiceFiscale);
	public List<Cliente> findByCodiceInterscambioContaining(String codiceInterscambio);
	public List<Cliente> findByPecContaining(String pec);
	public Cliente findByCommesse(Commessa commessa);
}
