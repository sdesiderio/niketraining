package cost.management.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cost.management.entities.Cliente;
import cost.management.entities.Commessa;
import cost.management.entities.Dipendente;

@Repository
@Transactional
public interface CommessaRepository extends JpaRepository<Commessa, String>{
	
	public List<Commessa> findByDescrizioneCommessaContaining(String descrizioneCommessa);
	public Commessa findByCodice(String codice);
	
	public List<Commessa> findByCodiceContaining(String codice);
	public List<Commessa> findByTipologiaCommessaContaining(String tipologiaCommessa);
	public List<Commessa> findByCliente(Cliente cliente);
	public List<Commessa> findByDataFineCommessaAfter(Date data);
	public List<Commessa> findByDataFineCommessaBefore(Date data);
	
}
